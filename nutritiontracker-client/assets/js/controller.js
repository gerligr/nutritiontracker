
function loadCompanies() {
    fetchCompanies().then(generateCompanyList);
}
function loadChildren() {
    fetchChildren().then(generateChildList);
}

function openCompanyModalForUpdate(id) {
    clearError();
    fetchCompany(id).then(company => {
        openCompanyModal();
        clearCompanyModal();
        fillCompanyModal(company);
    });
}

function openChildModalForUpdate(id) {
    clearChildError();
    fetchChild(id).then(child => {
        openChildModal();
        clearChildModal();
        fillChildModal(child);
    });
}

function openCompanyModalForInsert() {
    openCompanyModal();
    clearError();
    clearCompanyModal();
}

function openChildModalForInsert() {
    openChildModal();
    clearChildError();
    clearChildModal();
}
async function openMenuForInsert(childId) {
    clearMenuError();
    let menu = null;
    try {
        menu = await fetchMenu(childId);
    } catch(e) {
        console.log("Menu not found for child " + childId, e);
    }
    openMenuModal();
    fillMenuModal(menu, childId);
}

function saveFile(event) {
    event.preventDefault();
    let fileInput = getFileInput();
    uploadFile(fileInput.files[0]).then(response => fillCompanyModalLogoField(response.url));
}

function savePhotoFile(event) {
    event.preventDefault();
    let fileInput = getFileInput();
    uploadFile(fileInput.files[0]).then(response => fillChildModalPhotoField(response.url));
}


function saveChild() {
    let child = getChildFromModal();
    if (validateChildModal(child)) {
        postChild(child)
            .then(() => {
                closeChildModal();
                loadChildren();
            });
    }
}

async function calculateMenu() {
    let menu = getMenuFromModal();
    console.log(menu);
    if (validateMenuModal(menu)) {        
        await postMenu(menu);
        closeMenuModal();
        loadChildren();
        
        // console.log(result);
        // document.querySelector("#calories-" + result.childId).innerHTML = `<strong>${result.totalEnergy}</strong>`;
        // document.querySelector("#proteins-" + result.childId).innerHTML = `<strong>${result.totalProteins}</strong>`;
        // document.querySelector("#fats-" + result.childId).innerHTML = `<strong>${result.totalFats}</strong>`;
        // document.querySelector("#carbs-" + result.childId).innerHTML = `<strong>${result.totalCarbs}</strong>`;        
        // closeMenuModal();   
        // saveMenu(result);     
        
    }
}




function saveUser() {
    let user = getUserFromModal();
    if (validateUserModal(user)) {
        postUser(user)
            .then(() => {
                closeUserModal();
            });
    }
}


function removeCompany(id) {
    if (confirm('Soovid ettevõtet kustutada?')) {
        deleteCompany(id).then(loadCompanies)
    }
}

function dropChild(id) {
    if (confirm('Soovid lapse andmeid kustutada?')) {
        deleteChild(id).then(loadChildren)
    }
}

function loadChart() {
    fetchCompanies().then(generateCompanyChart)
}

function loginUser() {
    let credentials = getCredentialsFromLoginContainer();
    if (validateCredentials(credentials)) {
        login(credentials).then(session => {
            storeAuthentication(session);
            generateTopMenu();
            //clearMenuData();
            loadChildren();

        })
    }
}

function openRegistrationModal() {
    openUserModal();
    clearUserError();
    clearUserModal();
}

function openChildRegistrationModal() {
    openChildModal();
    clearChildError();
    clearChildModal();
}

function logoutUser() {
    clearAuthentication();
    generateTopMenu();
    showLoginContainer();
}
