var tablePerson = {
create: function(){
		$.ajax({
			url : '/provinsi/get-all',
			method : 'get',
			contetType : 'application/json',
			success : function(res, status, xhr) {
				data = "";
				$.each(res, function(i, v) {
					data += "<tr>";
					data += "<td>" + v.id + "</td>";
					data += "<td>" + v.kodeProvinsi + "</td>";
					data += "<td>" + v.namaProvinsi + "</td>";
					data += "<td>" + v.status + "</td>";
					data += "<tr>";
				});
				$('body-person').append(data);
				console.log(res);
			},
		error : function(e){
			alert(e);
			console.log(e);
		}
		});
		}
}		
