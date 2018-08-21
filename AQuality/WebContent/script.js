/*global $*/

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