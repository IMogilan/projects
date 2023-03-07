function changeEmployeePageSize(obj){
    window.location.href="/employee/page/1/" + obj.value + "?sortCondition=firstName&sortDirection=ASC";
}