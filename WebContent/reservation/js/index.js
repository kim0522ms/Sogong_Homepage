$(document).ready(function() {  
  $('.multiselect').multiselect();
  $('.datepicker').datepicker();  
  
  $('#datetimepicker1').datepicker(
          {
              format: 'dd/mm/yyyy',
              autoclose: true,
              forceParse: false,
              Default: true,
              pickDate: true,
              todayHighlight: true,

   });
});