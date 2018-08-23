/*global $*/


//日付を入れる


$(function(){
setInterval(function(){
var now = new Date();
var y = now.getFullYear();
var m = now.getMonth() + 1;
var d = now.getDate();
var w = now.getDay();
var wd = ['日', '月', '火', '水', '木', '金', '土'];
var h = now.getHours();
var mi = now.getMinutes();
var s = now.getSeconds();
$('#date').text(y + '年' + m + '月' + d + '日' + '(' + wd[w] + ')');
$('#date').append('\n\n'+h + '時' + mi + '分' + s + '秒');
}, 1000);
});


//selectの値をとってきて表示を変える
function outputSelectedValueAndText(obj)
{
    var idx = obj.selectedIndex;
    var value = obj.options[idx].value; // 値
    if(value === "収入"){
    	var items = document.getElementsByClassName("items");
    	var itemsblock3 = $(items[3]);
        var itemsnone = $(items[4]);
        itemsblock3.css("display","block");
        itemsnone.css("display","none");
    }else if(value === "支出"){
    	var items = document.getElementsByClassName("items");
    	var itemsblock4 = $(items[4]);
    	var itemsnone = $(items[3]);
    	itemsblock4.css("display","block");
    	itemsnone.css("display","none");
    }else if(value === "収入・支出"){
    	var items = document.getElementsByClassName("items");
    	var itemsblock = $(items[3]);
    	var itemsblock2 = $(items[4]);
    	itemsblock.css("display","block");
    	itemsblock2.css("display","block");

    }

}



//ナビゲーションの設定


var nav = $("#btnvalue");

$(nav.click(function(){
	$("#gnavi").slideToggle(350);
}));













