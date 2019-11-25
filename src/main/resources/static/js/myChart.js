var chartDataStr = decodeHtml(chartData);
var chartJasonArray = JSON.parse(chartDataStr);     // Converts theString from the decodeHtml() and save it to variable.

var arrayLength = chartJasonArray.length;
var numericData = [];
var labelData = [];

for (var i = 0; i < arrayLength; i++) {
    numericData[i] = chartJasonArray[i].value;
    labelData[i] = chartJasonArray[i].label;
}


// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',

    // chartData

    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#FF6384', '#b7ff02', '#008bff'],
            borderColor: '#5D5D5D',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
        title:{
            display: true,
            text: 'Project Statuses'
        }
    }
});


// [{"value": 1, "label": "COMPLETED"}, {"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]
function decodeHtml(html) {
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}
