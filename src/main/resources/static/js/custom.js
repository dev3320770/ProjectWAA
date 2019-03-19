    // popovers initialization - on hover
    $('[data-toggle="popover-hover"]').popover({
      html: true,
      trigger: 'hover',
      placement: 'top',
      content: function () { return 'Point Gained 1.5'; }
    });
    
    $('[data-toggle="date-hover"]').popover({
        html: true,
        trigger: 'hover',
        placement: 'top',
        content: function () { return 'Monday 22-02-2018'; }
      });

    // popovers initialization - on click
//    $('[data-toggle="popover-click"]').popover({
//      html: true,
//      trigger: 'click',
//      placement: 'bottom',
//      content: function () { return '<img src="' + $(this).data('img') + '" />'; }
//    });