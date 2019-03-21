// popovers initialization - on hover

$('[data-toggle="popover-hover"]').popover({
	html : true,
	trigger : 'hover',
	placement : 'top',
	content : function() {
		return 'Point Gained 1.5';
	}
});

$('[data-toggle="date-hover"]').popover({
	html : true,
	trigger : 'hover',
	placement : 'top',
	content : function() {
		return 'Monday 22-02-2018';
	}
});

$('form').submit(function(event) {

					event.preventDefault();
					var studentId = $("#studentId").val();	
					

					$.ajax({
								url : 'http://localhost:8080/api/students/details/'	+ studentId,
								type : 'GET',
								dataType : "json",
								success : function(student) {
									console.log(student);
									var html = '<table class="table table-bordered">'+
										'  <thead>'+
								   ' <tr>'+
								 
								    '  <th scope="col">Student ID</th>'+
								     ' <th scope="col">First Name</th>'+
								     ' <th scope="col">Last Name</th>'+
								     ' <th scope="col">Entry Date</th>'+
								       ' <th scope="col">Total Sessions</th>'+
								    '</tr>'+
								  '</thead>'+
								  '<tbody>'+
								   ' <tr>'+
								 
								     ' <td><a href="/students/details/?studentId='+student.studentId+'">'+student.studentId+'</a></td>'+
								      '<td>'+student.firstName+'</td>'+
								      '<td>'+student.lastName+'</td>'+
								      '<td>'+student.entryDate+'</td>'+
								      '<td>'+student.sessionTransactions.length+'</td>'+
								      '</tbody>'+
								      '</table>'+
								    '</tr>';
								

									$("#sucess").append(html).show();

								},
								error : function() {

									$("#error")
											.append(
													"<p class='alert alert-danger' role='alert'>No Student with ID : "+$("#studentId").val()+"</p>")
											.show();

								}
							});
				});
