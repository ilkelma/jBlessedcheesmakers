(function( $ ) {
  $.fn.boxFixer = function() {
    var maxHeight = 0;

    this.each(function(){
        if($(this).height() > maxHeight)
            maxHeight = $(this).height();
    }).each(function(){
        $(this).height(maxHeight);
    });
  };
})( jQuery );