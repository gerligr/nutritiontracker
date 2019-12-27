
function generateCompanyChart(companies) {
    document.getElementById("companyChart").innerHTML = /*html*/`
        <div class="row justify-content-center">
            <div class="col-lg-10" style="text-align: center">
                <strong style="font-size: 28px">Ettevõtete turuväärtused</strong>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-lg-10">
                <canvas id="companyChartCanvas"></canvas>
            </div>
        </div>
    `;

    let ctx = document.getElementById('companyChartCanvas').getContext('2d');
    let chartData = composeChartData(companies);
    new Chart(ctx, {
        type: 'pie',
        data: chartData,
        options: {}
    });
}
