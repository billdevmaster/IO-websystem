// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',

    // The data for our dataset
    data: {
        labels: ['January', 'February', 'March'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#FF6384','#b7ff02','#008bff'],
            borderColor: '#5D5D5D',
            data: [50, 10, 5]
        }]
    },

    // Configuration options go here
    options: {}
});