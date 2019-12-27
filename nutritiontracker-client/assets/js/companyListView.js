function generateChildList(children) { //kui lapse andmed on kord juba lisatud, siis saab sisselogimise view need kuvada
    document.getElementById("childList").innerHTML = "";
    let rows = "";
    for (let i = 0; i < children.length; i++) {
        let gender = 'info puudub';
        if (children[i].gender != null) {
            if (children[i].gender === 'M') {
                gender = "Poiss";
            } else {
                gender = "Tüdruk";
            }
        }
        let physicalActivity = 'info puudub';
        if (children[i].physicalActivity != null) {
            if (children[i].physicalActivity === 'low') {
                physicalActivity = "Väheaktiivne";
            } else if (children[i].physicalActivity === 'medium') {
                physicalActivity = "Aktiivne";
            } else if (children[i].physicalActivity === 'high') {
                physicalActivity = "Üliaktiivne";
            }
        }
        let age = 'info puudub';
        if (children[i].age != null) {
            age = children[i].age + "-aastane";
        }
        let menu = children[i].menu;

        let breakfast = '[ pole valitud ]';
        let breakfastAmount = '';
        let lunchsnack = '[ pole valitud ]';
        let lunchsnackAmount = '';
        let lunch = '[ pole valitud ]';
        let lunchAmount = '';
        let dinnersnack = '[ pole valitud ]';
        let dinnersnackAmount = '';
        let dinner = '[ pole valitud ]';
        let dinnerAmount = '';

        let totalEnergy = 'info puudub';
        let totalProteins = 'info puudub';
        let totalFats = 'info puudub';
        let totalCarbs = 'info puudub';

        let calculationTotalEnergy = 0;
        let calculationTotalProteins = 0;
        let calculationTotalFats = 0;
        let calculationTotalCarbs = 0;

        let nutritionSuggestion = null;

        if (children[i].menu != null) {


            if (menu.breakfast != null) {
                if (menu.breakfast === '1') {
                    breakfast = "Tatrapuder, võiga (vesi)";
                } else if (menu.breakfast === '4') {
                    breakfast = "Mannapuder, võiga (vesi)";
                } else if (menu.breakfast === '6') {
                    breakfast = "Omlett, juustuga, ahjus küpsetatud";
                }
            }

            if (menu.breakfastAmount != null) {
                breakfastAmount = " - " + menu.breakfastAmount + "g";
            }

            if (menu.lunchsnack != null) {
                if (menu.lunchsnack === '11') {
                    lunchsnack = "Porgand";
                } else if (menu.lunchsnack === '10') {
                    lunchsnack = "Pirn";
                } else if (menu.lunchsnack === '14') {
                    lunchsnack = "Paprika";
                } else if (menu.lunchsnack === '12') {
                    lunchsnack = "Kaalikas";
                } else if (menu.lunchsnack === '15') {
                    lunchsnack = "Banaanikeefir";
                } else if (menu.lunchsnack === '13') {
                    lunchsnack = "Banaan";
                }
            }

            if (menu.lunchsnackAmount != null) {
                lunchsnackAmount = " - " + menu.lunchsnackAmount + "g";
            }

            if (menu.lunch != null) {
                if (menu.lunch === '9') {
                    lunch = "Värskekapsahautis, veisehakklihaga, õliga";
                } else if (menu.lunch === '2') {
                    lunch = "Raguu, köögiviljadega, lihata, õliga";
                } else if (menu.lunch === '5') {
                    lunch = "Kana-kartuli-riisisupp, õliga";
                } else if (menu.lunch === '3') {
                    lunch = "Ühepajatoit, sealihast";
                } else if (menu.lunch === '8') {
                    lunch = "Pilaff, kanalihast";
                } else if (menu.lunch === '7') {
                    lunch = "Lasanje, veisehakklihaga, lisatud rasvaineta (piim 2,5%)";
                }
            }

            if (menu.lunchAmount != null) {
                lunchAmount = " - " + menu.lunchAmount + "g";
            }

            if (menu.dinnersnack != null) {
                if (menu.dinnersnack === '11') {
                    dinnersnack = "Porgand";
                } else if (menu.dinnersnack === '10') {
                    dinnersnack = "Pirn";
                } else if (menu.dinnersnack === '14') {
                    dinnersnack = "Paprika";
                } else if (menu.dinnersnack === '12') {
                    dinnersnack = "Kaalikas";
                } else if (menu.dinnersnack === '15') {
                    dinnersnack = "Banaanikeefir";
                } else if (menu.dinnersnack === '13') {
                    dinnersnack = "Banaan";
                }
            }

            if (menu.dinnersnackAmount != null) {
                dinnersnackAmount = " - " + menu.dinnersnackAmount + "g";
            }

            if (menu.dinner != null) {
                if (menu.dinner === '9') {
                    dinner = "Värskekapsahautis, veisehakklihaga, õliga";
                } else if (menu.dinner === '2') {
                    dinner = "Raguu, köögiviljadega, lihata, õliga";
                } else if (menu.dinner === '5') {
                    dinner = "Kana-kartuli-riisisupp, õliga";
                } else if (menu.dinner === '3') {
                    dinner = "Ühepajatoit, sealihast";
                } else if (menu.dinner === '8') {
                    dinner = "Pilaff, kanalihast";
                } else if (menu.dinner === '7') {
                    dinner = "Lasanje, veisehakklihaga, lisatud rasvaineta (piim 2,5%)";
                }
            }

            if (menu.dinnerAmount != null) {
                dinnerAmount = " - " + menu.dinnerAmount + "g";
            }

            let calculation = children[i].calculation;
            // let totalEnergy = 'info puudub';
            // let totalProteins = 'info puudub';
            // let totalFats = 'info puudub';
            // let totalCarbs = 'info puudub';

            if (calculation) {
                calculationTotalEnergy = calculation.totalEnergy;
                calculationTotalProteins = calculation.totalProteins;
                calculationTotalFats = calculation.totalFats;
                calculationTotalCarbs = calculation.totalCarbs;
            }
            let nutrition = children[i].nutrition;
            nutritionSuggestion = composeNutritionSuggestion(calculation, nutrition);


        }
        if (nutritionSuggestion == null) {
            nutritionSuggestion = composeNutritionSuggestion(null, null);
        }
        rows += `
        <div class="row justify-content-between">
            <div class="col-md-3">
                ${generateChildRowHeading(children[i])}
            </div>
            <div class="col" id="calcGraph" style="padding: 15px">
                ${generateGraphicRowElement(nutritionSuggestion)}  
            </div>
        </div>
        <div class="row justify-content-between">
            <div class="col-md-3" id="childData">                                   
                ${generateChildRowElement(age)}
                ${generateChildRowElement(gender)}
                ${generateChildRowElement(physicalActivity)} 
                ${generateChildRowElement2(children[i])}
                <br>   
            </div>  
            <div class="col-md-5 row-cols-2">                
                ${generateDataRowElement("Hommikusöök: ", breakfast + breakfastAmount)}  
                ${generateDataRowElement("Vahepala: ", lunchsnack + lunchsnackAmount)} 
                ${generateDataRowElement("Lõuna: ", lunch + lunchAmount)} 
                ${generateDataRowElement("Vahepala: ", dinnersnack + dinnersnackAmount)} 
                ${generateDataRowElement("Õhtu: ", dinner + dinnerAmount)}                    
            </div>
            <div class="col-md-4 col-sm-11" id="menuRows">    
                ${generateDataRowElement4("Väärtus", "Menüü kalorsus", "Hinnang")}
                ${generateDataRowElement3("Energia: ", calculationTotalEnergy > 0 ? calculationTotalEnergy + ' kcal' : 'info puudub', nutritionSuggestion.energyFromWholeText)} 
                ${generateDataRowElement3("Valgud: ", calculationTotalProteins > 0 ? calculationTotalProteins + ' kcal' : 'info puudub', nutritionSuggestion.proteinFromWholeText)} 
                ${generateDataRowElement3("Rasvad: ", calculationTotalFats > 0 ? calculationTotalFats + ' kcal' : 'info puudub', nutritionSuggestion.fatFromWholeText)} 
                ${generateDataRowElement3("Süsivesikud: ", calculationTotalCarbs > 0 ? calculationTotalCarbs + ' kcal' : 'info puudub', nutritionSuggestion.carbFromWholeText)}                                  
            </div>
        </div>
        <div class="row">
            <div class="col-12" style="padding: 10px;">
                <hr/>
            </div>
        </div>
                  
    `;

        document.getElementById("childList").innerHTML = /*html*/`
    <div class="row" id="childBox">
        <div class="col-lg-12">                              
        ${rows}
        </div>
    </div>
    `;
    } 
    initGraphics();
    
    
}

function generateCalculationsGraphic1(energyPct) {
    let graphicsHtml = "";
    if (parseInt(energyPct) > 0) {
        graphicsHtml = /*html*/`
                <div class="note-display color1" id="" data-note="${energyPct}">
                    <div class="circle">
                    <svg width="84" height="84" class="circle__svg">
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
                    </svg>                
                    <div class="percent">
                        <span class="percent__int" style="color:${energyPct > 100 || energyPct < 100 ? "#b60e38": "rgb(33, 37, 41)"}">${energyPct}</span>%
                    </div>
                    </div>
                
                    <span class="label">Energia</span>
                </div>
            `;
    }

    return `<div class="display-container">${graphicsHtml}</div>`;
}


function generateCalculationsGraphic2(proteinPct) {
    let graphicsHtml = "";
    if (parseInt(proteinPct) > 0) {
        graphicsHtml = /*html*/`
                <div class="note-display color2" id="" data-note="${proteinPct}">
                    <div class="circle">
                    <svg width="84" height="84" class="circle__svg">
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
                    </svg>
                
                    <div class="percent">
                        <span class="percent__int" style="color:${proteinPct > 100 || proteinPct < 100 ? "#b60e38": "rgb(33, 37, 41)"}">${proteinPct}</span>%
                    </div>
                    </div>
                
                    <span class="label">Valgud</span>
                </div>
            `;
    }

    return `<div class="display-container">${graphicsHtml}</div>`;
}

function generateCalculationsGraphic3(fatPct) {
    let graphicsHtml = "";
    if (parseInt(fatPct) > 0) {
        graphicsHtml = /*html*/`
                <div class="note-display color3" id="" data-note="${fatPct}">
                    <div class="circle">
                    <svg width="84" height="84" class="circle__svg">
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
                    </svg>
                
                    <div class="percent">
                        <span class="percent__int" style="color:${fatPct > 100 || fatPct < 100 ? "#b60e38": "rgb(33, 37, 41)"}">${fatPct}</span>%
                    </div>
                    </div>
                
                    <span class="label">Rasvad</span>
                </div>
            `;
    }

    return `<div class="display-container">${graphicsHtml}</div>`;
}

function generateCalculationsGraphic4(carbPct) {
    let graphicsHtml = "";
    if (parseInt(carbPct) > 0) {
        graphicsHtml = /*html*/`
                <div class="note-display color4" id="" data-note="${carbPct}">
                    <div class="circle">
                    <svg width="84" height="84" class="circle__svg">
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--path"></circle>
                        <circle cx="41" cy="41" r="38" class="circle__progress circle__progress--fill"></circle>
                    </svg>
                
                    <div class="percent">
                        <span class="percent__int" style="color:${carbPct > 100 || carbPct < 100 ? "#b60e38": "rgb(33, 37, 41)"}">${carbPct}</span>%
                    </div>
                    </div>
                
                    <span class="label">Süsivesikud</span>
                </div>
            `;
    }

    return `<div class="display-container">${graphicsHtml}</div>`;
}

function generateChildRowHeading(child) {
    return /*html*/`
        <div class="row">
            <div class="col-sm-6" style="padding:2px;">
                <strong style="font-size: 28px;">${child.name}</strong>
            </div>
            <div class="col-sm-6" style="padding: 2px;">
                ${generateChildMenuButton(child.id)}
            </div>                        
        </div>        
        <div class="row">
            <div class="col-md-6 col-sm-6" style="padding: 5px;">
                ${generateImageElement(child.photo)}
            </div>   
                            
        </div>
    `;
}

function generateChildMenuButton(childId) {
    return /*html*/`
        <div class="row justify-content-end">
            <div class="col">
                <button id="menuButton" class="btn btn-warning btn-block" onClick="openMenuForInsert(${childId})"><strong>Menüü valik<strong></button>
            </div>
        </div>
    `;
}



function generateChildRowElement(cell1Content) {
    return /*html*/`
        <div class="row">
            <div class="col-md-9">
                <div class="row">
                    ${generateChildRowTitleCell(cell1Content)}
                </div>
            </div>            
        </div>
    `;
}
function generateChildRowElement2(cell1Content) {
    return /*html*/`
        <div class="row">
            <div class="col-md-9">
                <div class="row justify-content-around">   
                    ${generateChildRowButtons1(cell1Content)} 
                    ${generateChildRowButtons2(cell1Content)}         
                </div>
            </div>           
        </div>
        
    `;
}


function generateDataRowElement(cell1Content, cell2Content) {
    return /*html*/`
        <div class="row">
            <div class="col-11">
                <div class="row">
                    ${generateChildRowDataTitleCell(cell1Content)} 
                    ${generateChildRowDataValueCell(cell2Content)}    
                </div>
            </div>  
        </div>
        
        
    `;
}



function generateGraphicRowElement(nutritionSuggestion) {
    return /*html*/`
        <div class="row">
            <div class="col-sm-12">
                <div class="row">
                    ${generateCalculationsGraphic1(nutritionSuggestion.energyFromWholePct)}                    
                    ${generateCalculationsGraphic2(nutritionSuggestion.proteinFromWholePct)}                    
                    ${generateCalculationsGraphic3(nutritionSuggestion.fatFromWholePct)} 
                    ${generateCalculationsGraphic4(nutritionSuggestion.carbFromWholePct)}
                </div>
            </div>  
        </div>       
        
    `;
}


function generateDataRowElement3(cell1Content, cell2Content, cell3Content) {
    return /*html*/`
        <div class="row">
            <div class="col">
                <div class="row justify-content-between" id="el3LogicBorder" style="margin:0; padding:2px;">
                    <div class="col-sm-4">
                        <div style="text-align: start; padding: 5px 2px">
                            ${cell1Content}
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div style="text-align: start; padding: 5px 2px">
                            ${cell2Content}
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div style="text-align: start; padding: 5px 2px; color:${cell3Content != "Normis" ? "#b60e38": "rgb(33, 37, 41)"}">
                            ${cell3Content}
                        </div>
                    </div>
                </div>
            </div>  
        </div>
        
        
    `;
}

function generateDataRowElement4(cell1Content, cell2Content, cell3Content) {
    return /*html*/`
        <div class="row">
            <div class="col justify-content-between" style="font-weight: bolder";>
                <div class="row" style="margin:0; padding:2px; border-bottom: 1px solid rgba(255, 227, 221, 1);">
                    <div class="col-sm-4">
                        <div style="padding: 5px 2px; text-align: start;">
                            ${cell1Content}
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div style="padding: 5px 2px; text-align: start;">
                            ${cell2Content}
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div style="padding: 5px 2px; text-align: start;">
                            ${cell3Content}
                        </div>
                    </div>
                </div>
            </div>  
        </div>
        
        
    `;
}

function generateChildRowTitleCell(text) {
    return /*html*/`
        <div class="col-sm-12" style="padding: 1px;">
            <div style="background: #FFE6D9; border-top: 1px solid #CCD1D1; border-bottom: 1px solid #CCD1D1; margin: 2px 0px; padding: 10px; text-align: center;">
                <strong>${text}</strong>
            </div>
        </div>
    `;
}
function generateChildRowDataTitleCell(text) {
    return /*html*/`
        <div id="ChildRowDataTitleCell" class="col-sm-4 col">
            <div style="padding: 5px; text-align: start;">
                ${text}
            </div>
        </div>
    `;
}

function generateChildRowDataValueCell(text) {
    return /*html*/`
        <div id="ChildRowDataValueCell" class="col-sm-8">
            <div style="padding: 5px; text-align: start;">
                ${text}
            </div>
        </div>
    `;
}

function generateChildRowButtons1(child) {
    return /*html*/`
        <div class="row">
            <div class="col">
                <button id="changeButton" class="btn btn-primary btn-block" onClick="openChildModalForUpdate(${child.id})">Muuda</button>
            </div>            
        </div>        
    `;
}

function generateChildRowButtons2(child) {
    return /*html*/`
        <div class="row">
            <div class="col">
                <button id="deleteButton" class="btn btn-danger btn-block" onClick="dropChild(${child.id})">Kustuta</button>
            </div>
        </div>        
    `;
}

function generateImageElement(photo) {
    if (!isEmpty(photo)) {
        return /*html*/`<img src="${photo}"/>`;
    } else {
        return "[PILT PUUDUB]";
    }
}




function openCompanyModal() {
    $("#companyModal").modal('show');
}

function openUserModal() {
    $("#userModal").modal('show');
}

function openChildModal() {
    $("#childModal").modal('show');
}
function openMenuModal() {
    $("#menuModal").modal('show');
}

function closeCompanyModal() {
    $("#companyModal").modal('hide');
}
function closeUserModal() {
    $("#userModal").modal('hide');
}

function closeChildModal() {
    $("#childModal").modal('hide');
}
function closeMenuModal() {
    $("#menuModal").modal('hide');
}


function clearUserError() {
    document.getElementById("userErrorPanel").innerHTML = "";
    document.getElementById("userErrorPanel").style.display = "none";
}

function showUserError(message) {
    document.getElementById("userErrorPanel").innerHTML = message;
    document.getElementById("userErrorPanel").style.display = "block";
}

function clearChildError() {
    document.getElementById("childErrorPanel").innerHTML = "";
    document.getElementById("childErrorPanel").style.display = "none";
}

function showChildError(message) {
    document.getElementById("childErrorPanel").innerHTML = message;
    document.getElementById("childErrorPanel").style.display = "block";
}
function clearMenuError() {
    document.getElementById("menuErrorPanel").innerHTML = "";
    document.getElementById("menuErrorPanel").style.display = "none";
}

function showMenuError(message) {
    document.getElementById("menuErrorPanel").innerHTML = message;
    document.getElementById("menuErrorPanel").style.display = "block";
}

// function clearMenuData() {
//     document.getElementById("menuTitleRows").innerHTML = "";
//     document.getElementById("menuTitleRows").style.display = "none";
// }

// function showMenuData(message) {
//     document.getElementById("showTitleRows").innerHTML = message;
//     document.getElementById("showTitleRows").style.display = "block";
// }

// function clearCompanyModal() {
//     document.getElementById("id").value = null;
//     document.getElementById("name").value = null;
//     document.getElementById("logo").value = null;
//     document.getElementById("established").value = null;
//     document.getElementById("employees").value = null;
//     document.getElementById("revenue").value = null;
//     document.getElementById("netIncome").value = null;
//     document.getElementById("securities").value = null;
//     document.getElementById("securityPrice").value = null;
//     document.getElementById("dividends").value = null;
// }

function clearUserModal() {
    document.getElementById("id").value = null;
    document.getElementById("registrationName").value = null;
    document.getElementById("registrationUsername").value = null;
    document.getElementById("registrationPassword").value = null;
    document.getElementById("email").value = null;

}

function clearMenuModal() {
    document.getElementById("childId").value = null;
    document.getElementById("breakfast").value = null;
    document.getElementById("breakfastAmount").value = null;
    document.getElementById("lunchsnack").value = null;
    document.getElementById("lunchsnackAmount").value = null;
    document.getElementById("lunch").value = null;
    document.getElementById("lunchAmount").value = null;
    document.getElementById("dinnersnack").value = null;
    document.getElementById("dinnersnackAmount").value = null;
    document.getElementById("dinner").value = null;
    document.getElementById("dinnerAmount").value = null;

}

function clearChildModal() {
    document.getElementById("childId").value = null;
    document.getElementById("childName").value = null;
    document.getElementById("photo").value = null;
    document.getElementById("age").value = null;
    document.getElementById("gender").value = null;
    document.getElementById("physicalActivity").value = null;
}

function fillCompanyModal(company) {
    document.getElementById("id").value = company.id;
    document.getElementById("name").value = company.name;
    document.getElementById("logo").value = company.logo;
    document.getElementById("established").value = company.established;
    document.getElementById("employees").value = company.employees;
    document.getElementById("revenue").value = company.revenue;
    document.getElementById("netIncome").value = company.netIncome;
    document.getElementById("securities").value = company.securities;
    document.getElementById("securityPrice").value = company.securityPrice;
    document.getElementById("dividends").value = company.dividends;
}

function fillChildModal(child) {
    document.getElementById("childId").value = child.id;
    document.getElementById("childName").value = child.name;
    document.getElementById("photo").value = child.photo;
    document.getElementById("age").value = child.age;
    document.getElementById("gender").value = child.gender;
    document.getElementById("physicalActivity").value = child.physicalActivity;
}

function fillMenuModal(menu, childId) {
    document.getElementById("childId").value = childId;
    if (menu) {
        document.getElementById("menuId").value = menu.id;
        document.getElementById("breakfast").value = menu.breakfast;
        document.getElementById("breakfastAmount").value = menu.breakfastAmount;
        document.getElementById("lunchsnack").value = menu.lunchsnack;
        document.getElementById("lunchsnackAmount").value = menu.lunchsnackAmount;
        document.getElementById("lunch").value = menu.lunch;
        document.getElementById("lunchAmount").value = menu.lunchAmount;
        document.getElementById("dinnersnack").value = menu.dinnersnack;
        document.getElementById("dinnersnackAmount").value = menu.dinnersnackAmount;
        document.getElementById("dinner").value = menu.dinner;
        document.getElementById("dinnerAmount").value = menu.dinnerAmount;
    } else {
        document.getElementById("menuId").value = "";
        document.getElementById("breakfast").value = "";
        document.getElementById("breakfastAmount").value = "";
        document.getElementById("lunchsnack").value = "";
        document.getElementById("lunchsnackAmount").value = "";
        document.getElementById("lunch").value = "";
        document.getElementById("lunchAmount").value = "";
        document.getElementById("dinnersnack").value = "";
        document.getElementById("dinnersnackAmount").value = "";
        document.getElementById("dinner").value = "";
        document.getElementById("dinnerAmount").value = "";
    }

}

function fillCompanyModalLogoField(logo) {
    document.getElementById("logo").value = logo;
}

function fillChildModalPhotoField(photo) {
    document.getElementById("photo").value = photo;
}

