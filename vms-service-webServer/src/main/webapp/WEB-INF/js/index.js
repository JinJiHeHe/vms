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
             $("#groupTree").tree("options").url =url+"?groupischecked="+groupischecked+"?id="+node.id;
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
         }
     });
    },
};
}();