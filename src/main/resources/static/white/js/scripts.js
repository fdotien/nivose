//


/////////////////////// ready
$(document).ready(function() {

  // --- search panel
  var searchBtn = $('#search').children('.searchBtn'),
    searchPanel = searchBtn.next(),
    searchP = searchBtn.parent();
  searchBtn.click(function(e){
    e.preventDefault();
    var _t = $(this);
    if(!_t.hasClass('active')) {
      _t.addClass('active')
      //.find('span')
      //.removeClass('icon-search icon-white')
      //.addClass('icon-remove');
      searchPanel.show();
    } else {
      _t.removeClass('active')
      //.find('span')
      //.addClass('icon-search icon-white')
      //.removeClass('icon-remove');
      searchPanel.hide();
    }
  }); // searchBtn.click //
  $(document).click(function(){
    searchBtn.removeClass('active')
      //.find('span')
      //.addClass('icon-search icon-white')
      //.removeClass('icon-remove');
    searchPanel.hide(0);
  });
  searchP.click(function(event){
    event.stopPropagation();
  });
  // --- end search panel

  /*----------------------------------------------------*/
  // Appear
  /*----------------------------------------------------*/
  var o = $('.animated');
  if (o.length > 0) {
    o.appear(function() {
      // console.log("111111111111");
        var elem = $(this);
        var animation = elem.data('animation');
        if ( !elem.hasClass('visible') ) {
          var animationDelay = elem.data('animation-delay');
          if ( animationDelay ) {
            setTimeout(function(){
                elem.addClass( animation + " visible" );
            }, animationDelay);
          } else {
            elem.addClass( animation + " visible" );
          }
        }
    });
  }




  // Animate number
  var o = $('.animated-distance');
  if (o.length > 0) {
    o.appear(function() {
      var elem = $(this);
      var b = elem.data('num');
      var d = elem.data('duration');
      var animationDelay = elem.data('animation-delay');
      if ( !animationDelay ) { animationDelay = 0; }
      elem.find('span').text("0" + '%');

      setTimeout(function(){
        elem.animate({ num: b }, {
          duration: d,
          // easing: 'easeOutExpo',
          step: function (num){
            a = (num).toFixed(0) + '%';
            elem.find('span').text(a);
            elem.css("width", a);
          }
        });
      }, animationDelay);
    });
  }








});

/////////////////////// load
$(window).load(function() {



});