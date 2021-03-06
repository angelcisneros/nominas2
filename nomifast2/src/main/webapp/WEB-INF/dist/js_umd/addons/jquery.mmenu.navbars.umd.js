(function ( factory ) {
    if ( typeof define === 'function' && define.amd )
    {
        // AMD. Register as an anonymous module.
        define( [ 'jquery' ], factory );
    }
    else if ( typeof exports === 'object' )
    {
        // Node/CommonJS
        factory( require( 'jquery' ) );
    }
    else
    {
        // Browser globals
        factory( jQuery );
    }
}( function ( jQuery ) {


/*	
 * jQuery mmenu navbar addon
 * mmenu.frebsite.nl
 *
 * Copyright (c) Fred Heusschen
 */
!function(n){var t="mmenu",a="navbars";n[t].addons[a]={setup:function(){var r=this,i=this.opts[a];if(this.conf[a],s=n[t].glbl,"undefined"!=typeof i){i instanceof Array||(i=[i]);var c={};n.each(i,function(s){var o=i[s];"boolean"==typeof o&&o&&(o={}),"object"!=typeof o&&(o={}),"undefined"==typeof o.content&&(o.content=["prev","title"]),o.content instanceof Array||(o.content=[o.content]),o=n.extend(!0,{},r.opts.navbar,o);var d=o.position,l=o.height;"number"!=typeof l&&(l=1),l=Math.min(4,Math.max(1,l)),"bottom"!=d&&(d="top"),c[d]||(c[d]=0),c[d]++;var h=n("<div />").addClass(e.navbar+" "+e.navbar+"-"+d+" "+e.navbar+"-"+d+"-"+c[d]+" "+e.navbar+"-size-"+l);c[d]+=l-1;for(var f=0,v=o.content.length;v>f;f++){var u=n[t].addons[a][o.content[f]]||!1;u?u.call(r,h,o):(u=o.content[f],u instanceof n||(u=n(o.content[f])),u.each(function(){h.append(n(this))}))}var p=Math.ceil(h.children().not("."+e.btn).length/l);p>1&&h.addClass(e.navbar+"-content-"+p),h.children("."+e.btn).length&&h.addClass(e.hasbtns),h.prependTo(r.$menu)});for(var o in c)r.$menu.addClass(e.hasnavbar+"-"+o+"-"+c[o])}},add:function(){e=n[t]._c,r=n[t]._d,i=n[t]._e,e.add("close hasbtns")},clickAnchor:function(){}},n[t].configuration.classNames[a]={panelTitle:"Title",panelNext:"Next",panelPrev:"Prev"};var e,r,i,s}(jQuery),/*	
 * jQuery mmenu navbar addon close content
 * mmenu.frebsite.nl
 *
 * Copyright (c) Fred Heusschen
 */
function(n){var t="mmenu",a="navbars",e="close";n[t].addons[a][e]=function(a){var e=n[t]._c,r=n[t].glbl;a.append('<a class="'+e.close+" "+e.btn+'" href="#"></a>');var i=function(n){a.find("."+e.close).attr("href","#"+n.attr("id"))};i.call(this,r.$page),this.bind("setPage",i)}}(jQuery),/*	
 * jQuery mmenu navbar addon next content
 * mmenu.frebsite.nl
 *
 * Copyright (c) Fred Heusschen
 */
function(n){var t="mmenu",a="navbars",e="next";n[t].addons[a][e]=function(e){var r=n[t]._c;e.append('<a class="'+r.next+" "+r.btn+'" href="#"></a>');var i=function(n){n=n||this.$menu.children("."+r.current);var t=e.find("."+r.next),i=n.find("."+this.conf.classNames[a].panelNext),s=i.attr("href"),c=i.html();t[s?"attr":"removeAttr"]("href",s),t[s||c?"removeClass":"addClass"](r.hidden),t.html(c)};this.bind("openPanel",i),this.bind("init",function(){i.call(this)})}}(jQuery),/*	
 * jQuery mmenu navbar addon prev content
 * mmenu.frebsite.nl
 *
 * Copyright (c) Fred Heusschen
 */
function(n){var t="mmenu",a="navbars",e="prev";n[t].addons[a][e]=function(e){var r=n[t]._c;e.append('<a class="'+r.prev+" "+r.btn+'" href="#"></a>'),this.bind("init",function(n){n.removeClass(r.hasnavbar)});var i=function(n){n=n||this.$menu.children("."+r.current);var t=e.find("."+r.prev),i=n.find("."+this.conf.classNames[a].panelPrev);i.length||(i=n.children("."+r.navbar).children("."+r.prev));var s=i.attr("href"),c=i.html();t[s?"attr":"removeAttr"]("href",s),t[s||c?"removeClass":"addClass"](r.hidden),t.html(c)};this.bind("openPanel",i),this.bind("init",function(){i.call(this)})}}(jQuery),/*	
 * jQuery mmenu navbar addon searchfield content
 * mmenu.frebsite.nl
 *
 * Copyright (c) Fred Heusschen
 */
function(n){var t="mmenu",a="navbars",e="searchfield";n[t].addons[a][e]=function(a){var e=n[t]._c,r=n('<div class="'+e.search+'" />').appendTo(a);"object"!=typeof this.opts.searchfield&&(this.opts.searchfield={}),this.opts.searchfield.add=!0,this.opts.searchfield.addTo=r}}(jQuery),/*	
 * jQuery mmenu navbar addon title content
 * mmenu.frebsite.nl
 *
 * Copyright (c) Fred Heusschen
 */
function(n){var t="mmenu",a="navbars",e="title";n[t].addons[a][e]=function(e,r){var i=n[t]._c;e.append('<a class="'+i.title+'"></a>');var s=function(n){n=n||this.$menu.children("."+i.current);var t=e.find("."+i.title),s=n.find("."+this.conf.classNames[a].panelTitle);s.length||(s=n.children("."+i.navbar).children("."+i.title));var c=s.attr("href"),o=s.html()||r.title;t[c?"attr":"removeAttr"]("href",c),t[c||o?"removeClass":"addClass"](i.hidden),t.html(o)};this.bind("openPanel",s),this.bind("init",function(){s.call(this)})}}(jQuery);
}));