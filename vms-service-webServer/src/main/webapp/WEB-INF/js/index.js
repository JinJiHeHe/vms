//组织机构树
var groupTree=function(){
    var isReloadVid = false;
    var dataRows={};
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
             var vid = node.id;
             if(checked) {

                 var url = "../map/getPointByVid.do";
                 $.post(url, {"vid": vid}, function (data) {
                   //  alert(data);
                   var arry = eval("("+data+")");
                  //  alert(arry.rows[0].lon+" "+arry.rows[0].lat);
                    $("#vehicleGrid").datagrid("loadData",arry);
                    var length= $('#vehicleGrid').datagrid("getRows").length;
                     for(var i=0;i<length;i++){
                         dataRows[vid]=i;
                     }
                    baiduMap.translateSelect(arry);
                 });
             }
             else{
                     var rowindex=dataRows[vid];
                    if(rowindex!=null){
                        var rows=$("#vehicleGrid").datagrid("getRows");
                        var id_num=rows[rowindex].vehicleNumber;
                        $("#vehicleGrid").datagrid("deleteRow",rowindex);

                           baiduMap.deleteMarker(id_num);
                    }
                 $.post("../map/deleteVid.do", {"vid": vid},function(data){

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
      var keyMap={};
      return{
    init:function(){
        map = new BMap.Map("baidumap");
        var point = new BMap.Point(116.404, 39.915);
        map.centerAndZoom(point, 12);               // 初始化地图，设置中心点坐标和地图级别
        map.addControl(new BMap.NavigationControl());
        map.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
        map.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用

    },
  deleteMarker:function(id_num){
      var allOverlay = map.getOverlays();
      for(var i = 0;i<allOverlay.length;i++) {
          if(allOverlay[i].toString()=="[object Marker]") {
              //删除指定经度的点
              if (allOverlay[i].getTitle() == id_num) {
                  map.removeOverlay(allOverlay[i]);
                  break;
              }
          }
      }
  },

    translateSelect:function (arry) {
       var lon=arry.rows[0].lon;
       var lat=arry.rows[0].lat;
       var vid=arry.rows[0].vehicleID;
       var id_num=arry.rows[0].vehicleNumber;

        var convertor=new BMap.Convertor();
        var gpsPoint = new BMap.Point(lon,lat);
        var pointArr = [];
        pointArr.push(gpsPoint);

        var mapVid=keyMap[id_num];

             if(mapVid!=null){  //判断上一个标记点
                    baiduMap.deleteMarker(mapVid);
             }
        convertor.translate(pointArr,1,5,function(data){   //原始经纬度转成百度坐标

            var point=data.points[0];
            var myIcon = new BMap.Icon("http://lbsyun.baidu.com/jsdemo/img/fox.gif",new BMap.Size(200,157));
            var marker2 = new BMap.Marker(point,{icon:myIcon});  // 创建标注
            var label=new BMap.Label(id_num);
            marker2.setLabel(label);
            marker2.setTitle(id_num);
            map.addOverlay(marker2);
            map.centerAndZoom(point, 12);
            keyMap[id_num]=id_num;//存到map中
        });
            return arry;
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
                var arry = eval("("+data+")");
                var arry1=baiduMap.translateSelect(arry);
                $("#vehicleGrid").datagrid("loadData",arry1);
            }
        }
    }
}();

