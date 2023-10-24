import Data.LoadProperities;

public class VariablesData {
     //////////////////////////////// All variables for organization////////////////////////////
    String OrgNormalName= LoadProperities.userData.getProperty("OrgNormalName");
    String OrgTopupName= LoadProperities.userData.getProperty("OrgTopupName");
    String OrgEnterpriseName= LoadProperities.userData.getProperty("OrgEnterpriseName");
    String OrgFuelBackName= LoadProperities.userData.getProperty("OrgFuelBackName");
    Float OrganizationChargeLimitTopup= Float.valueOf(LoadProperities.userData.getProperty("OrganizationChargeLimitTopup"));
    String OrgAddress= LoadProperities.userData.getProperty("OrgAddress");
    String OrganizationBalanceUpdateEnterprise= LoadProperities.userData.getProperty("OrganizationBalanceUpdateEnterprise");
    String OrganizationBalanceEnterpriseAttachment= System.getProperty("user.dir")+"\\src\\main\\resources\\invoice.png";
    String FuelBackLimit = LoadProperities.userData.getProperty("FuelBackLimit");
    String FuelBackPercentageForUser= LoadProperities.userData.getProperty("FuelBackPercentageForUser");
    String fromDayFualBack = LoadProperities.userData.getProperty("fromDayFualBack");
    String toDayFualBack= LoadProperities.userData.getProperty("toDayFualBack");
    // The xpath for the valid until month//
    String xpathMonthFualBack = "(//table[@class='ant-picker-content'])[1]//td";

    //------------------------------------Edit Org----------------------------//
    String editOrgName = LoadProperities.userData.getProperty("editOrgName");
    String editOrgAddress = LoadProperities.userData.getProperty("editOrgAddress");

    String editChargeLimitTopup= LoadProperities.userData.getProperty("editChargeLimitTopup");
    String editEnterpriseBalance = LoadProperities.userData.getProperty("editEnterpriseBalance");

    String editFuelBackLimit = LoadProperities.userData.getProperty("editFuelBackLimit");
    String editFuelBackPercentage= LoadProperities.userData.getProperty("editFuelBackPercentage");
    String editFromDayFualBack= LoadProperities.userData.getProperty("editFromDayFualBack");
    String editToDayFualBack= LoadProperities.userData.getProperty("editToDayFualBack");

    //------------------Delete Org ----------------------//

    String deleteNormalOrg = OrgNormalName + editOrgName;
    String deleteTopupOrg = OrgTopupName + editOrgName;
    String deleteEnterpriseOrg = OrgEnterpriseName + editOrgName;
    String deleteFuelBackOrg = OrgFuelBackName + editOrgName;


    //////////////////////All variables Venue page//////////////

    String venueOrgNormal= LoadProperities.userData.getProperty("venueOrgNormal");
    String venueOrgDelivery= LoadProperities.userData.getProperty("venueOrgDelivery");
    String venueOrgFuelBack= LoadProperities.userData.getProperty("venueOrgFuelBack");
    String venueNormalName= LoadProperities.userData.getProperty("venueNormalName");
    String venueDeliveryName= LoadProperities.userData.getProperty("venueDeliveryName");
    String venueFuelBackName= LoadProperities.userData.getProperty("venueFuelBackName");
    String venueCity= LoadProperities.userData.getProperty("venueCity");
    String numberWorkingShifts= LoadProperities.userData.getProperty("numberWorkingShifts");
    String workFrom= LoadProperities.userData.getProperty("workFrom");
    String workTo= LoadProperities.userData.getProperty("workTo");
    String venueLocation= LoadProperities.userData.getProperty("venueLocation");

    String carModel= LoadProperities.userData.getProperty("carModel");
    String manufactureName=LoadProperities.userData.getProperty("manufactureName");
    String manufacturedYear= LoadProperities.userData.getProperty("manufacturedYear");
    String plateNumber= LoadProperities.userData.getProperty("plateNumber");
    String chassisNumber= LoadProperities.userData.getProperty("chassisNumber");
    String DeliveryFees= LoadProperities.userData.getProperty("DeliveryFees");
    String tankCapacity=LoadProperities.userData.getProperty("tankCapacity");
    String tankProduct=LoadProperities.userData.getProperty("tankProduct");
    String area1=LoadProperities.userData.getProperty("area1");
    String area2=LoadProperities.userData.getProperty("area2");

    String venueNameEditD = " " + LoadProperities.userData.getProperty("venueNameEditD");
    String venueDeliveryNameDelete = venueDeliveryName + " " + LoadProperities.userData.getProperty("venueNameEditD");
    String venueFuelBackEditName = LoadProperities.userData.getProperty("venueFuelBackEditName");
    String venueCityEdit = LoadProperities.userData.getProperty("venueCityEdit");
    String carModelEdit= LoadProperities.userData.getProperty("carModelEdit");
    String manufactureNameEdit=" " + LoadProperities.userData.getProperty("manufactureNameEdit");
    String manufacturedYearEdit= LoadProperities.userData.getProperty("manufacturedYearEdit");
    String plateNumberEdit= LoadProperities.userData.getProperty("plateNumberEdit");
    String chassisNumberEdit= " " + LoadProperities.userData.getProperty("chassisNumberEdit");
    String deliveryFeesEdit= LoadProperities.userData.getProperty("deliveryFeesEdit");
    String tankCapacityEdit=LoadProperities.userData.getProperty("tankCapacityEdit");
    String tankProductEdit=LoadProperities.userData.getProperty("tankProductEdit");
    String numberWorkingShiftsEdit=LoadProperities.userData.getProperty("numberWorkingShiftsEdit");

    //////////////////////All variables Vendors page//////////////////////////////////////////////////
    String vendorName=LoadProperities.userData.getProperty("vendorName");
    String venueOfVendor=LoadProperities.userData.getProperty("venueOfVendor");
    String vendorNameFuelBack =LoadProperities.userData.getProperty("vendorNameFuelBack");
    String venueOfVendorFuelBack =LoadProperities.userData.getProperty("venueOfVendorFuelBack");
    String venueFuelBackLimit = LoadProperities.userData.getProperty("venueFuelBackLimit");
    String venueFuelBackPercentageForUser= LoadProperities.userData.getProperty("venueFuelBackPercentageForUser");
    String venuefromDayFualBack = LoadProperities.userData.getProperty("venuefromDayFualBack");
    String venuetoDayFualBack= LoadProperities.userData.getProperty("venuetoDayFualBack");
    String vendorNameEdit= " " + LoadProperities.userData.getProperty("vendorNameEdit");
    String vendorNameFuelBackEdit= LoadProperities.userData.getProperty("vendorNameFuelBackEdit");
    String venueOfVendorEdit= LoadProperities.userData.getProperty("venueOfVendorEdit");
    String vendorFuelBackLimitEdit  = LoadProperities.userData.getProperty("vendorFuelBackLimitEdit");
    String vendorFuelBackPercentageForUserEdit  = LoadProperities.userData.getProperty("vendorFuelBackPercentageForUserEdit");

    String vendorNameDelete = vendorName + " " + LoadProperities.userData.getProperty("vendorNameEdit");

///////////////////////////All Data for Enterprise Employee//////////////////////////////////////////
    String cellPhoneEmployee= LoadProperities.userData.getProperty("CellPhoneEmployee");
    String firstNameEmployee = LoadProperities.userData.getProperty("firstNameEmployee");
    String lastNameEmployee = LoadProperities.userData.getProperty("lastNameEmployee");
    String    fileEmployees  = System.getProperty("user.dir")+"\\src\\main\\resources\\bulk-employee.xlsx";

//////////////////////All variables for Card Stock//////////////
    String newVehicleStock = LoadProperities.userData.getProperty("newVehicleStock");
    String newEmployeeStock = LoadProperities.userData.getProperty("newEmployeeStock");
    String stockDailyLimit = LoadProperities.userData.getProperty("stockDailyLimit");
    String stockWeeklyLimit = LoadProperities.userData.getProperty("stockWeeklyLimit");
    String stockTopupAmount = LoadProperities.userData.getProperty("stockTopupAmount");
    String periodDaily = LoadProperities.userData.getProperty("periodDaily");
    String periodWeekly = LoadProperities.userData.getProperty("periodWeekly");
    String periodMonthly = LoadProperities.userData.getProperty("periodMonthly");
    String stockOffDay1 = LoadProperities.userData.getProperty("stockOffDay1");
    String stockOffDay2 = LoadProperities.userData.getProperty("stockOffDay2");
    String topupWeeklyDay = LoadProperities.userData.getProperty("topupWeeklyDay");
    String topupMonthlyDay = LoadProperities.userData.getProperty("topupMonthlyDay");
    String bulkCardsCount = LoadProperities.userData.getProperty("bulkCardsCount");
    String fileTopUpStockV  = System.getProperty("user.dir")+"\\src\\main\\resources\\stock_cards_TopUp.csv";
    String fileTopUpStockE  = System.getProperty("user.dir")+"\\src\\main\\resources\\stock_TopUp_Emp.csv";
    String  stockTopUpAmountEmp = LoadProperities.userData.getProperty("stockTopUpAmountEmp");
    String  offerTitle = LoadProperities.userData.getProperty("offerTitle");
   //----------------Edit Stock ---------------//
    String editVehicleStock = LoadProperities.userData.getProperty("editVehicleStock");
    String editEmployeeStock = LoadProperities.userData.getProperty("editEmployeeStock");

    Float editStockDailyLimit = Float.valueOf(LoadProperities.userData.getProperty("editStockDailyLimit"));
    Float editStockMonthlyLimit = Float.valueOf(LoadProperities.userData.getProperty("editStockMonthlyLimit"));
    Float editStockTopupAmount = Float.valueOf(LoadProperities.userData.getProperty("editStockTopupAmount"));
    String stockTopUpAmount  = LoadProperities.userData.getProperty("stockTopUpAmount");

    ////////////////////////////////All variables for Cards////////////////////////////

    String cardAmountV = LoadProperities.userData.getProperty("cardAmountV");
    String  stockForCardV = LoadProperities.userData.getProperty("stockForCardV");
    String  cardLabelV= LoadProperities.userData.getProperty("cardLabelV");
    String  cardMonthlyLimit= LoadProperities.userData.getProperty("cardMonthlyLimit");
    String  cardMinLimit= LoadProperities.userData.getProperty("cardMinLimit");
    String  cardMaxLimit= LoadProperities.userData.getProperty("cardMaxLimit");
    String  cardtopupAmount= LoadProperities.userData.getProperty("cardtopupAmount");
    String  cardOffDay1= LoadProperities.userData.getProperty("cardOffDay1");

    String cardAmountE = LoadProperities.userData.getProperty("cardAmountE");
    String  stockForCardE = LoadProperities.userData.getProperty("stockForCardE");
    String  cardLabelE= LoadProperities.userData.getProperty("cardLabelE");

    String employeeName = firstNameEmployee + " " + lastNameEmployee;
    String cardOverDraftLimit = LoadProperities.userData.getProperty("cardOverDraftLimit");
    String cardDailyLimit = LoadProperities.userData.getProperty("cardDailyLimit");
    String cardLabelEditV = LoadProperities.userData.getProperty("cardLabelEditV");
    String cardLabelEditE = " " + LoadProperities.userData.getProperty("cardLabelEditE");
    String cardOverdraftLimitEdit = LoadProperities.userData.getProperty("cardOverdraftLimitEdit");
    String cardMonthlyLimitEdit = LoadProperities.userData.getProperty("cardMonthlyLimitEdit");
    String cardtopupSchedulerAmountEdit = LoadProperities.userData.getProperty("cardtopupSchedulerAmountEdit");
    String cardDailyLimitEdit= LoadProperities.userData.getProperty("cardDailyLimitEdit");
    String cardMaxLimitEdit= LoadProperities.userData.getProperty("cardMaxLimitEdit");
    String cardMinLimitEdit= LoadProperities.userData.getProperty("cardMinLimitEdit");
    String fileBulkCards  = System.getProperty("user.dir")+"\\src\\main\\resources\\bulk-cards-sheet.xlsx";
    String cardFullLabelE = cardLabelE + " " + LoadProperities.userData.getProperty("cardLabelEditE");

    ///------------------------Bulk cards file ------------------------------//
    String fileCardLabel1= LoadProperities.userData.getProperty("fileCardLabel1");
    String  fileCardLabel2= LoadProperities.userData.getProperty("fileCardLabel2");
    String fileCardAmount1= LoadProperities.userData.getProperty("fileCardAmount1");
    String fileCardAmount2= LoadProperities.userData.getProperty("fileCardAmount2");

    ///------------------------Topup and deduct cards ------------------------------//
    String cardTopUpAmount = LoadProperities.userData.getProperty("cardTopUpAmount");
    String cardDedcutAmount = "- " + LoadProperities.userData.getProperty("cardDecutAmount");

    ////////////////////////////////////////////All variables for transactions/////////////////////////////////////

    String transfromDay = LoadProperities.userData.getProperty("transfromDay");
    String transtoDay = LoadProperities.userData.getProperty("transtoDay");
    String transactionID = LoadProperities.userData.getProperty("transactionID");
    String transactionType = LoadProperities.userData.getProperty("transactionType");
    String transtatus = LoadProperities.userData.getProperty("transtatus");
    String transPaymentMethod = LoadProperities.userData.getProperty("transPaymentMethod");
    String transShortID= LoadProperities.userData.getProperty("transShortID");
    String transReceiptID = LoadProperities.userData.getProperty("transReceiptID");
    String transUser = LoadProperities.userData.getProperty("transUser");
    String transPOSNumber = LoadProperities.userData.getProperty("transPOSNumber");
    String transProduct = LoadProperities.userData.getProperty("transProduct");
    String transVenueCode = LoadProperities.userData.getProperty("transVenueCode");
    String transVenueCity = LoadProperities.userData.getProperty("transVenueCity");
    String transCardID = LoadProperities.userData.getProperty("transCardID");
    String transEnterpriseOrg = LoadProperities.userData.getProperty("transEnterpriseOrg");
    String transCardLabel = LoadProperities.userData.getProperty("transCardLabel");
    String transCardStock = LoadProperities.userData.getProperty("transCardStock");

    ////////////////////////////////All variables for offers and deals////////////////////////////
    String offerNormalTitle = LoadProperities.userData.getProperty("offerNormalTitle");
    String offerWatchTitle = LoadProperities.userData.getProperty("offerWatchTitle");
    String offerClickTitle = LoadProperities.userData.getProperty("offerClickTitle");
    String offerDownloadTitle = LoadProperities.userData.getProperty("offerDownloadTitle");
    String offerCat = LoadProperities.userData.getProperty("offerCat");
    String offerOrg = LoadProperities.userData.getProperty("offerOrg");
    String offerVenue = LoadProperities.userData.getProperty("offerVenue");
    String offerDescription = LoadProperities.userData.getProperty("offerDescription");
    String offerCashBackAmount = LoadProperities.userData.getProperty("offerCashBackAmount");
    String fileWatchOffer  = System.getProperty("user.dir")+"\\src\\main\\resources\\watchOffer.mp4";
    String actionLinkClick = LoadProperities.userData.getProperty("actionLinkClick");
    String actionLinkDownload = LoadProperities.userData.getProperty("actionLinkDownload");
    //----------------------------Edit offers--------------------//
    String offerNormalTitleEdit = " " + LoadProperities.userData.getProperty("offerNormalTitleEdit");
    String offerWatchTitleEdit = LoadProperities.userData.getProperty("offerWatchTitleEdit");
    String offerClickTitleEdit =  LoadProperities.userData.getProperty("offerClickTitleEdit");
    String offerDownloadTitleEdit = " " + LoadProperities.userData.getProperty("offerDownloadTitleEdit");
    String offerOrgEdit = LoadProperities.userData.getProperty("offerOrgEdit");
    String offerVenueEdit1= LoadProperities.userData.getProperty("offerVenueEdit1");
    String offerVenueEdit2 = LoadProperities.userData.getProperty("offerVenueEdit2");
    String offerDescriptionEdit= LoadProperities.userData.getProperty("offerDescriptionEdit");
    String offerCashBackAmountEdit = LoadProperities.userData.getProperty("offerCashBackAmountEdit");
    String actionLinkClickEdit = LoadProperities.userData.getProperty("actionLinkClickEdit");
    String actionLinkDownloadEdit= LoadProperities.userData.getProperty("actionLinkDownloadEdit");
    //-------------------------Delete offers-------------------------------//
    String deleteNormalOffer = offerNormalTitle + " " + LoadProperities.userData.getProperty("offerNormalTitleEdit");
    String deleteDownloadOffer = offerDownloadTitle + " " + LoadProperities.userData.getProperty("offerDownloadTitleEdit");
    //----------------------------Deals------------------------//
    String dealTitle= LoadProperities.userData.getProperty("dealTitle");
    String dealArabicTitle= LoadProperities.userData.getProperty("dealArabicTitle","UTF-8");
    String dealGift=LoadProperities.userData.getProperty("dealGift");
    String dealAmount=LoadProperities.userData.getProperty("dealAmount");
    String dealOrg1=LoadProperities.userData.getProperty("dealOrg1");
    String dealOrg2=LoadProperities.userData.getProperty("dealOrg2");
    String dealVenue1=LoadProperities.userData.getProperty("dealVenue1");
    String dealVenue2=LoadProperities.userData.getProperty("dealVenue2");
    String dealProduct1=LoadProperities.userData.getProperty("dealProduct1");
    String dealProduct2=LoadProperities.userData.getProperty("dealProduct2");
    String dealValidUntilFrom=LoadProperities.userData.getProperty("dealValidUntilFrom");
    String dealValidUntilTo=LoadProperities.userData.getProperty("dealValidUntilTo");
    String dealCongMessage=LoadProperities.userData.getProperty("dealCongMessage");
    String dealArabicCongMessage=LoadProperities.userData.getProperty("dealArabicCongMessage");

    String dealTitleEdit= LoadProperities.userData.getProperty("dealTitleEdit");
    String dealArabicTitleEdit= " " + LoadProperities.userData.getProperty("dealArabicTitle");
    String dealGiftEdit=LoadProperities.userData.getProperty("dealGiftEdit");
    String dealAmountEdit=LoadProperities.userData.getProperty("dealAmountEdit");
    String dealOrg1Edit=LoadProperities.userData.getProperty("dealOrg1Edit");
    String dealOrg2Edit=LoadProperities.userData.getProperty("dealOrg2Edit");
    String dealVenue1Edit=LoadProperities.userData.getProperty("dealVenue1Edit");
    String dealVenue2Edit=LoadProperities.userData.getProperty("dealVenue2Edit");
    String dealProduct1Edit=LoadProperities.userData.getProperty("dealProduct1Edit");
    String dealProduct2Edit=LoadProperities.userData.getProperty("dealProduct2Edit");
    String dealValidUntilFromEdit=LoadProperities.userData.getProperty("dealValidUntilFromEdit");
    String dealValidUntilToEdit=LoadProperities.userData.getProperty("dealValidUntilToEdit");
    String dealCongMessageEdit=LoadProperities.userData.getProperty("dealCongMessageEdit");
    String dealArabicCongMessageEdit= " " + LoadProperities.userData.getProperty("dealArabicCongMessageEdit");

    ////////////////////////////////All variables for Ad Campaign and Ads////////////////////////////

    String campaignName= LoadProperities.userData.getProperty("campaignName");
    String campaignOrg= LoadProperities.userData.getProperty("campaignOrg");
    String campaignValidUntilFrom = LoadProperities.userData.getProperty("campaignValidUntilFrom");
    String campaignValidUntilTo = LoadProperities.userData.getProperty("campaignValidUntilTo");

    String campaignNameEdit= LoadProperities.userData.getProperty("campaignNameEdit");
    String campaignOrgEdit= LoadProperities.userData.getProperty("campaignOrgEdit");
    String campaignValidUntilFromEdit = LoadProperities.userData.getProperty("campaignValidUntilFromEdit");
    String campaignValidUntilToEdit = LoadProperities.userData.getProperty("campaignValidUntilToEdit");

    //----------------------------------Ads -----------------------------------------//
    String adTitle= LoadProperities.userData.getProperty("adTitle");
    String adPlacement= LoadProperities.userData.getProperty("adPlacement");
    String adOrg= LoadProperities.userData.getProperty("adOrg");
    String adCampaign= LoadProperities.userData.getProperty("adCampaign");
    String adsImage  = System.getProperty("user.dir")+"\\src\\main\\resources\\Ads.png";

    String adTitleEdit= LoadProperities.userData.getProperty("adTitleEdit");
    String adPlacementEdit= LoadProperities.userData.getProperty("adPlacementEdit");
    String adOrgEdit= LoadProperities.userData.getProperty("adOrgEdit");
    String adCampaignEdit= LoadProperities.userData.getProperty("adCampaignEdit");
}
