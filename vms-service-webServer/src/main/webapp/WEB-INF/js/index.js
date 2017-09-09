//组织机构树
var groupTree=function(){
    var isReloadVid = false;
return {
    init: function () {
     $('#groupTree').tree({
          url:'../monitor/getGroupTree.do',
         checkbox:true,

         onBeforeExpand:function(node){//在节点展开之前触发
             var groupischecked = 'false';
             if (node.checked) {//当前节点选中
                 groupischecked = 'true';
             } else {
                 groupischecked = 'false';
             }
             var url = "../monitor/getGroupTree.do";
             $("#groupTree").tree("options").url =url+"?attributes="+node.attributes+"?id="+node.id;
             return true;
         },

         onLoadSuccess:function(node){//在数据加载成功以后触发
             //alert($('#groupTree').tree('getRoots'));
             if(isReloadVid){
                 $('#groupTree').tree('expandAll');
             } else {
                 //默认展开第一个根节点
                 var roots = $('#groupTree').tree('getRoots');

                 $('#groupTree').tree('expand', roots[0].target);
             }
             isReloadVid = false;
         },
         onSelect:function(node){
             if (node.state=="closed") {//如果是折叠的则展开
                 $('#groupTree').tree('expand', node.target);
             } else {//如果是展开的则折叠
                 $('#groupTree').tree('collapse', node.target);
             }
         },
         onCheck:function (node,checked) {
             //alert("hahha");
             if(checked) {
                 var vid = node.id;
                // alert(vid);
                 var url = "../map/getPointByVid.do";
                 $.post(url, {"vid": vid}, function (data) {
                   //  alert(data);
                   var arry = eval("("+data+")");
                  //  alert(arry.rows[0].lon+" "+arry.rows[0].lat);
                    $("#vehicleGrid").datagrid("loadData",arry);
                    baiduMap.translateSelect(arry);
                 });
             }
         }

     });
    },
};
}();
//地图
var baiduMap=function(){
       var map ;          // 创建地图实例
      // 创建点坐标

      return{
    init:function(){
        map = new BMap.Map("baidumap");
        var point = new BMap.Point(116.404, 39.915);
        map.centerAndZoom(point, 12);               // 初始化地图，设置中心点坐标和地图级别
        map.addControl(new BMap.NavigationControl());
        map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

    },


    translateSelect:function (arry) {
       var lon=arry.rows[0].lon;
       var lat=arry.rows[0].lat;
       // alert(lon);
        var convertor=new BMap.Convertor();


        var gpsPoint = new BMap.Point(lon,lat);
        var pointArr = [];
        pointArr.push(gpsPoint);
        convertor.translate(pointArr,1,5,function(data){
            //alert(data.points[0]);
            var point=data.points[0];
            var myIcon = new BMap.Icon("http://lbsyun.baidu.com/jsdemo/img/fox.gif",new BMap.Size(200,157));
            var marker2 = new BMap.Marker(point,{icon:myIcon});  // 创建标注
            map.addOverlay(marker2);
            map.centerAndZoom(point, 12);

        });     //原始经纬度转成百度坐标
    }
}

}();
var websockethandler=function(){
    return {
        init: function () {
            // if (!window.WebSocket) {
            //     alert("不支持websocket");
            // }
            // else alert("支持websocket");
            var ws = new WebSocket('ws://localhost:8080/vms/webSocketServer');
            ws.onmessage=function (event) {
                var data=event.data;
               // alert(data);
                var arry = eval("("+data+")");
               // alert(arry);
                $("#vehicleGrid").datagrid("loadData",arry);
                baiduMap.translateSelect(arry);
            }
        }
    }
}();

