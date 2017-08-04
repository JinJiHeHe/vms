var groupTree=function(){
return {
    init: function () {
     $('#groupTree').tree({
          url:'../monitor/getGroupTree.do',
         checkbox:true,

         onBeforeExpand:function(node){//在节点展开之前触发
             var groupChecked = 'false';
             if (node.checked) {//当前节点选中
                 groupChecked = 'true';
             } else {
                 groupChecked = 'false';
             }
             var url = "../monitor/getGroupTree.do";
             $("#group").tree("options").url =url+"?groupischecked="+groupischecked+"&treeStatus="+SearchBar.getTreeStatus();
             return true;
         },
         onSelect : function(node){
             if (node.state=="closed") {//如果是折叠的则展开
                 $('#group').tree('expand', node.target);
             } else {//如果是展开的则折叠
                 $('#group').tree('collapse', node.target);
             }
         },

         onLoadSuccess:function(node){//在数据加载成功以后触发
             if(isReloadVid){
                 $('#group').tree('expandAll');
             } else {
                 //默认展开第一个根节点
                 var roots = $('#group').tree('getRoots');
                 $('#group').tree('expand', roots[0].target);
             }
             isReloadVid = false;
         }
     });
    },
};
}();