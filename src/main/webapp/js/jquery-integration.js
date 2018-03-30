function cfxFilter() {
	var elementClass = $(this).attr("class");
	return /^cfx\-/i.test(this.nodeName) | /\s*cfx-.+\s*/i.test(elementClass) | /^cfx/i.test(elementClass);
}


/**
 * 
 */

$(function() {
	
	/**
	 * Reads attributes of item(s) and populate them to css, depending on prefix: <br />
	 * * attribute, that starts with '--' will be added to css as is <br />
	 * * attribute, that starts with '@' will be added to css without leading '@' <br />
	 */
	$.fn.populateAttr = function() {
		$(this).each(function() {
			var $style = $(this).get(0).style;
	  		$.each(this.attributes, function() {
	    		if(this.specified) {
	       			if(/--.+/.test(this.name)) {
						$style.setProperty(this.name, this.value);
	       			}
					if(/@.+/.test(this.name)) {
						$style.setProperty(this.name.substring(1), this.value);
	       			}
	    		}
	  		});
		});
	};
	
	/**
	 * Checks if given element is a 'cfx' one - is a 'cfx-' tag name or has at least one 'cfx*' class
	 */
	$.fn.isCfx = function() {
		var elementClass = $(this).get(0).attr("class");
		return /^cfx\-/i.test($(this).get(0).nodeName) | /\s+cfx\-.+\s+/i.test(elementClass) | /\s+cfx\s+/i.test(elementClass);
	};
	
	/**
	 *  Finds all cfx elements(see #isCfxElementFilter) and
	 *  propagates properties/attributes(see #populateAttributes).
	 */
	$.fn.childCfx = function() {
		return $(this).find("*").filter(cfxFilter);
	}

	$.fn.triggerNotEmptyClass = function(cls) { 
		$(this).keyup(function(){
			if($(this).val()){
				$(this).addClass(cls);
			} else {
				$(this).removeClass(cls);
			}
		});
		$(this).change(function(){
			if($(this).val()){
				$(this).addClass(cls);
			} else {
				$(this).removeClass(cls);
			}
		});
		
		$(this).trigger('keyup');
		$(this).change();
	};
	
	$.fn.triggerNotEmpty = function() { 
		$(this).keyup(function(){
			if($(this).val()){
				$(this).addClass("not-empty");
			} else {
				$(this).removeClass("not-empty");
			}
		});
		$(this).change(function(){
			if($(this).val()){
				$(this).addClass("not-empty");
			} else {
				$(this).removeClass("not-empty");
			}
		});
		
		$(this).trigger('keyup');
		$(this).change();
	};
	
});