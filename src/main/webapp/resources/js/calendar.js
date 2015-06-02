$(function() {
		var data=JSON.parse($("#data").val());
		var bh = $('body').height()-250;
		$('#calendar').fullCalendar({
			height: bh,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek'
			},
			lang:'zh-cn',
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: data
		});
	$('#calendar').addClass('panel panel-default');
	$('.fc-toolbar').wrap("<div class='panel-heading'></div>");
	$('.fc-view-container').wrap("<div class='panel-body'></div>");
	
});