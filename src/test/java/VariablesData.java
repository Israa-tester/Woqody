public class VariablesData {
     //////////////////////////////// All variables for organization////////////////////////////
    String OrgNormalName= "AutoNormal";
    String OrgTopupName= "AutoTopup";
    String OrgEnterpriseName= "AutoEnterprise";
    String OrgFuelBackName= "AutoFuelBack";
    Float OrganizationChargeLimitTopup= 10F;
    String OrgAddress= "Mansoura,Al-Galaa";
    Float OrganizationBalanceUpdateEnterprise= 1000F;
    String OrganizationBalanceEnterpriseAttachment= "D:\\AutomationWoqody\\Dashboard_Woqody\\src\\main\\resources\\invoice.png";
    Float FuelBackLimit = 1000F;
    Float FuelBackPercentageForUser= 1.5F;
    String fromDayFualBack = "25";
    String toDayFualBack= "29";
    // The xpath for the valid until month//
    String xpathMonthFualBack = "(//table[@class='ant-picker-content'])[1]//td";
    //------------------------------------Edit Org----------------------------//
    String editOrgName = " Org";
    String editOrgAddress = "Tanta- Egypt";

    Float editChargeLimitTopup= 155F;
    Float editEnterpriseBalance = 500F;

    Float editFuelBackLimit = 5000F;
    Float editFuelBackPercentage= 1F;
    String editFromDayFualBack= "27";
    String editToDayFualBack= "28";

    /////////////////////////Delete Org/////////////

    String deleteNormalOrg = OrgNormalName + editOrgName;
    String deleteTopupOrg = OrgTopupName + editOrgName;
    String deleteEnterpriseOrg = OrgEnterpriseName + editOrgName;
    String deleteFuelBackOrg = OrgFuelBackName + editOrgName;





}
