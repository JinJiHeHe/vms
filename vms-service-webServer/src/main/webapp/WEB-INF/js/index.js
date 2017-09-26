//组织机构树
var groupTree=function(){
    var isReloadVid = false;
    var dataRows={};
    var dataChecked={};
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
                   var arry = eval("("+data+")");
                   console.log(arry);
                     $("#monitor")[0].contentWindow.$('#vehicleGrid').datagrid("loadData",arry);

                    var length=  $("#monitor")[0].contentWindow.$('#vehicleGrid').datagrid("getRows").length;
                     for(var i=0;i<length;i++){
                         dataRows[vid]=i;
                     }
                     document.getElementById("monitor").contentWindow.baiduMap.translateSelect(arry);
                     //$("#monitor").contents().translateSelect(arry);
                 });
             }
             else{
                     var rowindex=dataRows[vid];
                         if(rowindex!=null){
                        var rows=$("#monitor")[0].contentWindow.$('#vehicleGrid').datagrid("getRows");
                        var id_num=rows[rowindex].vehicleNumber;
                             $("#monitor")[0].contentWindow.$('#vehicleGrid').datagrid("deleteRow",rowindex);

                             document.getElementById("monitor").contentWindow.baiduMap.deleteMarker(id_num);
                    }
                 $.post("../map/deleteVid.do", {"vid": vid},function(data){

                 });
             }
         }

     });
    },
};
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
                var arry1=  document.getElementById("monitor").contentWindow.baiduMap.translateSelect(arry);
                $("#monitor")[0].contentWindow.$('#vehicleGrid').datagrid("loadData",arry);
            }
            ws.onclose=function(event){
                ws=new WebSocket('ws://localhost:8080/vms/webSocketServer');
            }
        }
    }
}();
var searchBox=function(){
    return {
        init:function(){
            //   var arry=$.post("../monitor/getVehicleList.do",function(data){
            //     return data;
            //
            // });
            // console.log(arry);
            $("#searchBox").combobox({
                prompt:'输入车牌号',
               url:"../monitor/getVehicleList.do",
                // data:arry,
                valueField : "vid",
                textField : "id_num",
                editable:true ,
                filter: function(q, row){
                    // alert("...");
                    if(q!=""){
                    if(q.length>=3){
                    var opts = $(this).combobox('options');
                    return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配
                    }
                    }
                },
                onSelect:function(record){
                      // alert(record);
                      // console.log(record);
                    var node = $('#groupTree').tree('find', record.vid);
                    $('#groupTree').tree('check', node.target);
                },

            //     onShowPanel:function(){
            //         // $('#easyui-searchBox').next(".combo").hide();
            //        var text= $("#searchBox").combobox("getText");
            //        var value=$("#searchBox").combobox("getValue");
            //        var data=$("#searchBox").combobox("getData");
            //        var arry={};
            //        arry["vid"]=value;
            //        arry["id_num"]=text;
            //         alert(data);
            //         console.log(data[1]);
            //         if(text!=""||text!=null){
            //             if(data.indexOf(arry)>0){
            //                 $("#searchBox").combobox("clear");
            // };
            //         }
            //     }

            });
        }
    }
}();

