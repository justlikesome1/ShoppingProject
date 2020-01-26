/*
 * ×÷Õß£º¹ùÁÕçø
 * °æ±¾£º1.0
 * */
$(".getUrl").click(function(){
      
		
		var ta=$(this).attr("target");
		var urlStr=$(this).attr("href");
		if($(this).attr("type")=="submit")
		{
			urlStr=$(this).closest("form").attr("action");
			ta=$(this).closest("form").attr("target");
		}
		 
		$.ajax({
	        cache: false,
	        type: "POST",
	        url:urlStr,
	        data:$(this).closest("form").serialize(),
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	$(ta).html(data);
	        }
	    });
	
	    
	     return false;
});

document.addEventListener('DOMNodeInserted',function(){
	

	$(".getUrl[tag!=true]").each(function(){
		
		if($._data(this,"events")&&$._data(this,"events")["click"]){
			$(this).attr("tag","true");
			//$(this).css("border","1px solid blue");
		}
		else
		{
			//$(this).css("border","1px solid red");
			$(this).click(
					
					function(){
						var ta=$(this).attr("target");
						var urlStr=$(this).attr("href");
						if($(this).attr("type")=="submit")
						{
							urlStr=$(this).closest("form").attr("action");
							ta=$(this).closest("form").attr("target");
						}
						$.ajax({
					        cache: false,
					        type: "POST",
					        url:urlStr,
					        data:$(this).closest("form").serialize(),
					        async: false,
					        error: function(request) {
					            alert("Connection error");
					        },
					        success: function(data) {
					        	 
					        	$(ta).html(data);
					        }
					    });
					
					    
					     return false;
					}
			
			);					
			
			
		}
	});
},false);



document.addEventListener('DOMAttrModified',function(){
	$(".getUrl").addClass("getUrl");

});
document.addEventListener('DOMNodeRemoved',function(){
	$(".getUrl").addClass("getUrl");

});



