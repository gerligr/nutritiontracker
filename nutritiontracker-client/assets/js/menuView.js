
function generateTopMenu() {
    let logoutLink = "";
    let greeting = "";
    if (!isEmpty(getUsername())) {
        logoutLink = /*html*/`<a href="javascript:logoutUser()" style="color: #C6C6C6; font-weight: bold;">Logi välja</a>`;
        greeting = /*html*/`<a style="color: #fff; font-weight: bold;">Tere tulemast, ${getUsername()}!</a>`;
    }

    document.getElementById("topMenuContainer").innerHTML = /*html*/`
        <div style="padding: 10px; color: white; font-style: italic; background:black;">
            <div class="row">
                <div class="col-sm-4">
                    <strong>Toitumise jälgimise APP!</strong>
                </div>
                <div class="col-sm-4" style="text-align: center; font-style: normal; font-size: 18px">
                    ${greeting}
                </div>
                <div class="col-sm-4" style="text-align: right; font-style: normal;">
                    ${logoutLink}
                </div>
            </div>
        </div>
    `;
}

function showLoginContainer() {
    document.getElementById("loginContainer").style.display = "block";
    document.getElementById("mainContainer").style.display = "none";
}

function showMainContainer() {
    document.getElementById("loginContainer").style.display = "none";
    document.getElementById("mainContainer").style.display = "block";
}

function changeView() {
    if(document.getElementById("viewSelect").value === "CHART") {
        showCompanyChart();
    } else {
        showCompanyList();
    }
}

// function showMenuData() {
//     if ()
// }

function showCompanyList() {
    document.getElementById("companyList").style.display = "block";
   // document.getElementById("companyChart").style.display = "none";
    loadCompanies();
}

function showChildList() {
    document.getElementById("childList").style.display = "block";
   // document.getElementById("companyChart").style.display = "none";
    loadChildren();
}

// function showCompanyChart() {
//     document.getElementById("companyList").style.display = "none";
//     document.getElementById("companyChart").style.display = "block";
//     loadChart();
// }
