
/**
 * Filter, that checks if given element is a type of 'cfx'
 */

function isCfxElementFilter() {
	var elementClass = $(this).attr("class");
	
	return /^cfx\-/i.test(this.nodeName) | /^cfx\-/i.test(elementClass) | /^cfx/i.test(elementClass);
}

/**
 * Propagates attributes.
 * Atributes with '@' at the beginnins of the name will be added
 * as css style
 * Attribute, that starts with '--' - will be added as is to css.
 * Attribute with '--' at the beginning of the name - means css
 * variable.
 * 
 */
function populateAttributes(i) {
	
    $style = $(this).get(0).style;
    	
	$(this).each(function() {
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
}

/**
 *  Finds all cfx elements(see #isCfxElementFilter) and
 *  propagates properties/attributes(see #populateAttributes).
 */
function rebindCfxAttributes(target) {
	var cfxElements = target.find("*").filter(isCfxElementFilter);
	cfxElements.each(populateAttributes);
}

/**
 *  Bind click handler to all cfx menus tuggle buttons.
 */
function rebindCfxTugleButtons() {
	$("[type=tuggle-button]").each(function() {
		
		$(this).click(function(e) {
			e.preventDefault();
			var ref = $(this).attr('tuggle-target');
			var target = $(ref);
			if($(this).hasClass("tuggle-on")) {
				$(this).removeClass("tuggle-on");
				target.removeClass("tuggle-on");
			} else {
				$(this).addClass("tuggle-on");
				target.addClass("tuggle-on");
			}
		});
	});
}


/**
 *
 */
function rebindNaviagetion() {
	$(".navigate").each(function() {
		
		$(this).click(function(e) {
			e.preventDefault();
			var ref = $(this).attr("href");
			
			if(ref.startsWith("away:")) {
				var url = ref.substr(5);
				var win = window.open(url, '_blank');
  				win.focus();
  				return false;
			}
			
			if(ref.startsWith("view:")) {
				window.location.href = ref.substr(5);
				return false;
			}
		});
	});
}

/**
 * Helper function. Check if page was scrolled to anchor and
 * and modify attribute state to "most-top"
 * Used for menu to slide-down and stay on top of page when
 * it was scrolled out.
 */
function moveByScroller($anchor, $scroller) {

    var move = function() {
        var st = $(window).scrollTop();
        var ot = $anchor.offset().top;
        if(st > ot) {
            $scroller.addClass("top-of-page");
        } else {
            $scroller.removeClass("top-of-page");
        }
    };
    $(window).scroll(move);
    move();
}

/**
 * Callback function. Called when document is totally loaded.
 * Used to fire all required scrips when document is loaded and ready.
 */
$(function() {

	/** binding attributes to css for all cfx-* classes and cfx-* tags **/
	rebindCfxAttributes($(document));

	$(document).on("DOMNodeInsertedIntoDocument", function(e) {
		rebindCfxAttributes($(e.target));
	});
	

	/** Process all tuggle <a> tugs */
	rebindCfxTugleButtons();
	
	/** rebind navigate links **/
	rebindNaviagetion();
	
	/** Adding handle to menu scrollig to make it always on top */
	moveByScroller($("#menu-anchor"), $("#main-menu-bar"));

	$(".cfx-loader").removeClass("active");
	
});
 