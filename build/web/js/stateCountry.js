/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var postState = '';
var postCountry = '';

// State table
var state = '\
US:AK:Alaska|\
US:AL:Alabama|\
US:AR:Arkansas|\
US:AS:American Samoa|\
US:AZ:Arizona|\
US:CA:California|\
US:CO:Colorado|\
US:CT:Connecticut|\
US:DC:D.C.|\
US:DE:Delaware|\
US:FL:Florida|\
US:FM:Micronesia|\
US:GA:Georgia|\
US:GU:Guam|\
US:HI:Hawaii|\
US:IA:Iowa|\
US:ID:Idaho|\
US:IL:Illinois|\
US:IN:Indiana|\
US:KS:Kansas|\
US:KY:Kentucky|\
US:LA:Louisiana|\
US:MA:Massachusetts|\
US:MD:Maryland|\
US:ME:Maine|\
US:MH:Marshall Islands|\
US:MI:Michigan|\
US:MN:Minnesota|\
US:MO:Missouri|\
US:MP:Marianas|\
US:MS:Mississippi|\
US:MT:Montana|\
US:NC:North Carolina|\
US:ND:North Dakota|\
US:NE:Nebraska|\
US:NH:New Hampshire|\
US:NJ:New Jersey|\
US:NM:New Mexico|\
US:NV:Nevada|\
US:NY:New York|\
US:OH:Ohio|\
US:OK:Oklahoma|\
US:OR:Oregon|\
US:PA:Pennsylvania|\
US:PR:Puerto Rico|\
US:PW:Palau|\
US:RI:Rhode Island|\
US:SC:South Carolina|\
US:SD:South Dakota|\
US:TN:Tennessee|\
US:TX:Texas|\
US:UT:Utah|\
US:VA:Virginia|\
US:VI:Virgin Islands|\
US:VT:Vermont|\
US:WA:Washington|\
US:WI:Wisconsin|\
US:WV:West Virginia|\
US:WY:Wyoming|\
US:AA:Military Americas|\
US:AE:Military Euro/ME/Can|\
US:AP:Military Pacific|\
CA:AB:Alberta|\
CA:MB:Manitoba|\
CA:AB:Alberta|\
CA:BC:British Columbia|\
CA:MB:Manitoba|\
CA:NB:New Brunswick|\
CA:NL:Newfoundland, Labrador|\
CA:NS:Nova Scotia|\
CA:NT:Northwest Territory|\
CA:NU:Nunavut|\
CA:ON:Ontario|\
CA:PE:Prince Edward Island|\
CA:QC:Quebec|\
CA:SK:Saskatchewan|\
CA:YT:Yukon Territory|\
AU:AAT:Australian Antarctic Terr.|\
AU:ACT:Australian Capital Terr.|\
AU:NT:Northern Territory|\
AU:NSW:New South Wales|\
AU:QLD:Queensland|\
AU:SA:South Australia|\
AU:TAS:Tasmania|\
AU:VIC:Victoria|\
AU:WA:Western Australia|\
BR:AC:Acre|\
BR:AL:Alagoas|\
BR:AM:Amazonas|\
BR:AP:Amapa|\
BR:BA:Baia|\
BR:CE:Ceara|\
BR:DF:Distrito Federal|\
BR:ES:Espirito Santo|\
BR:FN:Fernando de Noronha|\
BR:GO:Goias|\
BR:MA:Maranhao|\
BR:MG:Minas Gerais|\
BR:MS:Mato Grosso do Sul|\
BR:MT:Mato Grosso|\
BR:PA:Para|\
BR:PB:Paraiba|\
BR:PE:Pernambuco|\
BR:PI:Piaui|\
BR:PR:Parana|\
BR:RJ:Rio de Janeiro|\
BR:RN:Rio Grande do Norte|\
BR:RO:Rondonia|\
BR:RR:Roraima|\
BR:RS:Rio Grande do Sul|\
BR:SC:Santa Catarina|\
BR:SE:Sergipe|\
BR:SP:Sao Paulo|\
BR:TO:Tocatins|\
NL:DR:Drente|\
NL:FL:Flevoland|\
NL:FR:Friesland|\
NL:GL:Gelderland|\
NL:GR:Groningen|\
NL:LB:Limburg|\
NL:NB:Noord Brabant|\
NL:NH:Noord Holland|\
NL:OV:Overijssel|\
NL:UT:Utrecht|\
NL:ZH:Zuid Holland|\
NL:ZL:Zeeland|\
UK:AVON:Avon|\
UK:BEDS:Bedfordshire|\
UK:BERKS:Berkshire|\
UK:BUCKS:Buckinghamshire|\
UK:CAMBS:Cambridgeshire|\
UK:CHESH:Cheshire|\
UK:CLEVE:Cleveland|\
UK:CORN:Cornwall|\
UK:CUMB:Cumbria|\
UK:DERBY:Derbyshire|\
UK:DEVON:Devon|\
UK:DORSET:Dorset|\
UK:DURHAM:Durham|\
UK:ESSEX:Essex|\
UK:GLOUS:Gloucestershire|\
UK:GLONDON:Greater London|\
UK:GMANCH:Greater Manchester|\
UK:HANTS:Hampshire|\
UK:HERWOR:Hereford, Worcestershire|\
UK:HERTS:Hertfordshire|\
UK:HUMBER:Humberside|\
UK:IOM:Isle of Man|\
UK:IOW:Isle of Wight|\
UK:KENT:Kent|\
UK:LANCS:Lancashire|\
UK:LEICS:Leicestershire|\
UK:LINCS:Lincolnshire|\
UK:MERSEY:Merseyside|\
UK:NORF:Norfolk|\
UK:NHANTS:Northamptonshire|\
UK:NTHUMB:Northumberland|\
UK:NOTTS:Nottinghamshire|\
UK:OXON:Oxfordshire|\
UK:SHROPS:Shropshire|\
UK:SOM:Somerset|\
UK:STAFFS:Staffordshire|\
UK:SUFF:Suffolk|\
UK:SURREY:Surrey|\
UK:SUSS:Sussex|\
UK:WARKS:Warwickshire|\
UK:WMID:West Midlands|\
UK:WILTS:Wiltshire|\
UK:YORK:Yorkshire|\
EI:CO ANTRIM:County Antrim|\
EI:CO ARMAGH:County Armagh|\
EI:CO DOWN:County Down|\
EI:CO FERMANAGH:County Fermanagh|\
EI:CO DERRY:County Londonderry|\
EI:CO TYRONE:County Tyrone|\
EI:CO CAVAN:County Cavan|\
EI:CO DONEGAL:County Donegal|\
EI:CO MONAGHAN:County Monaghan|\
EI:CO DUBLIN:County Dublin|\
EI:CO CARLOW:County Carlow|\
EI:CO KILDARE:County Kildare|\
EI:CO KILKENNY:County Kilkenny|\
EI:CO LAOIS:County Laois|\
EI:CO LONGFORD:County Longford|\
EI:CO LOUTH:County Louth|\
EI:CO MEATH:County Meath|\
EI:CO OFFALY:County Offaly|\
EI:CO WESTMEATH:County Westmeath|\
EI:CO WEXFORD:County Wexford|\
EI:CO WICKLOW:County Wicklow|\
EI:CO GALWAY:County Galway|\
EI:CO MAYO:County Mayo|\
EI:CO LEITRIM:County Leitrim|\
EI:CO ROSCOMMON:County Roscommon|\
EI:CO SLIGO:County Sligo|\
EI:CO CLARE:County Clare|\
EI:CO CORK:County Cork|\
EI:CO KERRY:County Kerry|\
EI:CO LIMERICK:County Limerick|\
EI:CO TIPPERARY:County Tipperary|\
EI:CO WATERFORD:County Waterford|\
';

// Country data table
var country = '\
US:United States|\
UM:United States Minor Outly Isl|\
AF:Afghanistan|\
AL:Albania|\
DZ:Algeria|\
AS:American Samoa|\
AD:Andorra|\
AO:Angola|\
AI:Anguilla|\
AQ:Antarctica|\
AG:Antigua and Barbuda|\
AR:Argentina|\
AM:Armenia|\
AW:Aruba|\
AU:Australia|\
AT:Austria|\
AZ:Azerbaijan|\
AP:Azores|\
BS:Bahamas|\
BH:Bahrain|\
BD:Bangladesh|\
BB:Barbados|\
BY:Belarus|\
BE:Belgium|\
BZ:Belize|\
BJ:Benin|\
BM:Bermuda|\
BT:Bhutan|\
BO:Bolivia|\
BA:Bosnia And Herzegowina|\
XB:Bosnia-Herzegovina|\
BW:Botswana|\
BV:Bouvet Island|\
BR:Brazil|\
IO:British Indian Ocean Terr|\
VG:British Virgin Islands|\
BN:Brunei Darussalam|\
BG:Bulgaria|\
BF:Burkina Faso|\
BI:Burundi|\
KH:Cambodia|\
CM:Cameroon|\
CA:Canada|\
CV:Cape Verde|\
KY:Cayman Islands|\
CF:Central African Repub|\
TD:Chad|\
CL:Chile|\
CN:China|\
CX:Christmas Island|\
CC:Cocos (Keeling) Isl|\
CO:Colombia|\
KM:Comoros|\
CG:Congo|\
CD:Congo, Dem Repub Of|\
CK:Cook Islands|\
XE:Corsica|\
CR:Costa Rica|\
CI:Cote d` Ivoire (Ivory Coast)|\
HR:Croatia|\
CU:Cuba|\
CY:Cyprus|\
CZ:Czech Republic|\
DK:Denmark|\
DJ:Djibouti|\
DM:Dominica|\
DO:Dominican Republic|\
TP:East Timor|\
EC:Ecuador|\
EG:Egypt|\
SV:El Salvador|\
GQ:Equatorial Guinea|\
ER:Eritrea|\
EE:Estonia|\
ET:Ethiopia|\
FK:Falkland Isl (Malvinas)|\
FO:Faroe Islands|\
FJ:Fiji|\
FI:Finland|\
FR:France (Includes Monaco)|\
FX:France, Metropolitan|\
GF:French Guiana|\
PF:French Polynesia|\
TA:French Polynesia (Tahiti)|\
TF:French South Terr|\
GA:Gabon|\
GM:Gambia|\
GE:Georgia|\
DE:Germany|\
GH:Ghana|\
GI:Gibraltar|\
GR:Greece|\
GL:Greenland|\
GD:Grenada|\
GP:Guadeloupe|\
GU:Guam|\
GT:Guatemala|\
GN:Guinea|\
GW:Guinea-Bissau|\
GY:Guyana|\
HT:Haiti|\
HM:Heard, Mc Donald Isl|\
VA:Vatican City State|\
HN:Honduras|\
HK:Hong Kong|\
HU:Hungary|\
IS:Iceland|\
IN:India|\
ID:Indonesia|\
IR:Iran|\
IQ:Iraq|\
IE:Ireland|\
EI:Ireland (Eire)|\
IL:Israel|\
IT:Italy|\
JM:Jamaica|\
JP:Japan|\
JO:Jordan|\
KZ:Kazakhstan|\
KE:Kenya|\
KI:Kiribati|\
KP:Korea, Dem People\'S Repub|\
KW:Kuwait|\
KG:Kyrgyzstan|\
LA:Laos|\
LV:Latvia|\
LB:Lebanon|\
LS:Lesotho|\
LR:Liberia|\
LY:Libya|\
LI:Liechtenstein|\
LT:Lithuania|\
LU:Luxembourg|\
MO:Macao|\
MK:Macedonia|\
MG:Madagascar|\
ME:Madeira Islands|\
MW:Malawi|\
MY:Malaysia|\
MV:Maldives|\
ML:Mali|\
MT:Malta|\
MH:Marshall Islands|\
MQ:Martinique|\
MR:Mauritania|\
MU:Mauritius|\
YT:Mayotte|\
MX:Mexico|\
FM:Micronesia, Fed States Of|\
MD:Moldova, Republic Of|\
MC:Monaco|\
MN:Mongolia|\
MS:Montserrat|\
MA:Morocco|\
MZ:Mozambique|\
MM:Myanmar (Burma)|\
NA:Namibia|\
NR:Nauru|\
NP:Nepal|\
NL:Netherlands|\
AN:Netherlands Antilles|\
NC:New Caledonia|\
NZ:New Zealand|\
NI:Nicaragua|\
NE:Niger|\
NG:Nigeria|\
NU:Niue|\
NF:Norfolk Island|\
MP:Northern Mariana Isl|\
NO:Norway|\
OM:Oman|\
PK:Pakistan|\
PW:Palau|\
PS:Palestinian Terr, Occ|\
PA:Panama|\
PG:Papua New Guinea|\
PY:Paraguay|\
PE:Peru|\
PH:Philippines|\
PN:Pitcairn|\
PL:Poland|\
PT:Portugal|\
PR:Puerto Rico|\
QA:Qatar|\
RE:Reunion|\
RO:Romania|\
RU:Russian Federation|\
RW:Rwanda|\
KN:Saint Kitts And Nevis|\
SM:San Marino|\
ST:Sao Tome and Principe|\
SA:Saudi Arabia|\
SN:Senegal|\
XS:Serbia-Montenegro|\
SC:Seychelles|\
SL:Sierra Leone|\
SG:Singapore|\
SK:Slovak Republic|\
SI:Slovenia|\
SB:Solomon Islands|\
SO:Somalia|\
ZA:South Africa|\
GS:South Georgia, The South Sand|\
KR:South Korea|\
ES:Spain|\
LK:Sri Lanka|\
NV:St. Christopher and Nevis|\
SH:St. Helena|\
LC:St. Lucia|\
PM:St. Pierre and Miquelon|\
VC:St. Vincent, the Grenadines|\
SD:Sudan|\
SR:Suriname|\
SJ:Svalbard And Jan Mayen Isl|\
SZ:Swaziland|\
SE:Sweden|\
CH:Switzerland|\
SY:Syrian Arab Republic|\
TW:Taiwan|\
TJ:Tajikistan|\
TZ:Tanzania|\
TH:Thailand|\
TG:Togo|\
TK:Tokelau|\
TO:Tonga|\
TT:Trinidad and Tobago|\
XU:Tristan da Cunha|\
TN:Tunisia|\
TR:Turkey|\
TM:Turkmenistan|\
TC:Turks and Caicos Islands|\
TV:Tuvalu|\
UG:Uganda|\
UA:Ukraine|\
AE:United Arab Emirates|\
UK:United Kingdom|\
GB:Great Britain|\
UY:Uruguay|\
UZ:Uzbekistan|\
VU:Vanuatu|\
XV:Vatican City|\
VE:Venezuela|\
VN:Vietnam|\
VI:Virgin Islands (U.S.)|\
WF:Wallis and Furuna Islands|\
EH:Western Sahara|\
WS:Western Samoa|\
YE:Yemen|\
YU:Yugoslavia|\
ZR:Zaire|\
ZM:Zambia|\
ZW:Zimbabwe|\
';
//
function num2stringpad(number, length) {
    var str = '' + number;
    while (str.length < length) {
        str = '0' + str;
    }
    return str;
}

function TrimString(sInString) {
    if ( sInString ) {
        sInString = sInString.replace( /^\s+/g, "" );// strip leading
        return sInString.replace( /\s+$/g, "" );// strip trailing
    }
}
function PadDigits(n, totalDigits) {
        n = n.toString(); 
        var pd = ''; 
        if (totalDigits > n.length) 
        { 
            for (i=0; i < (totalDigits-n.length); i++) 
            { 
                pd += '0'; 
            } 
        } 
        return pd + n.toString(); 
} 
//function initCountry(country) {
function initCountry() {
 	//populateCountry(country);
	populateCountry('Select');
    populateState();
}
function initAddrCountry() {
 	//populateCountry(country);
	populateAddrCountry('Select');
    populateAddrState();
}

// Populates the country selected with the counties from the country list
function populateCountry(defaultCountry) {
  if ( postCountry != '' ) {
    defaultCountry = postCountry;
  }
  var countryLineArray = country.split('|');  // Split into lines

  var selObj = document.getElementById('country');
  
  selObj.options[0] = new Option('Select Country','');
  selObj.selectedIndex = 0;
  
  for (var loop = 0; loop < countryLineArray.length; loop++) {
    lineArray = countryLineArray[loop].split(':');
    countryCode  = TrimString(lineArray[0]);
    countryName  = TrimString(lineArray[1]);
    if ( countryCode != '' ) {
      selObj.options[loop + 1] = new Option(countryName, countryCode);
	  //alert('Option: ', countryCode, countryName);
    }
    if ( defaultCountry == countryCode ) {
      selObj.selectedIndex = loop + 1;
    }
  }
}
function populateAddrCountry(defaultCountry) {
  if ( postCountry != '' ) {
    defaultCountry = postCountry;
  }
  var v_countryLineArray = country.split('|');  // Split into lines
  
  var o_addrcountrySelect = document.getElementById('addrcountrySelect');
  
  o_addrcountrySelect.options[0] = new Option('Select Country','');
  o_addrcountrySelect.selectedIndex = 0;
  
  for (var loop = 0; loop < v_countryLineArray.length; loop++) {
    v_lineArray = v_countryLineArray[loop].split(':');
    v_addrcountryCode  = TrimString(v_lineArray[0]);
    v_addrcountryName  = TrimString(v_lineArray[1]);
    if ( v_addrcountryCode != '' ) {
      o_addrcountrySelect.options[loop + 1] = new Option(v_addrcountryName, v_addrcountryCode);
    }
    if ( defaultCountry == v_addrcountryCode ) {
      o_addrcountrySelect.selectedIndex = loop + 1;
    }
  }
}

function populateState() {
  var selObj = document.getElementById('state');
  var foundState = false;
  // Empty options just in case new drop down is shorter
  if ( selObj.type == 'select-one' ) {
    for (var i = 0; i < selObj.options.length; i++) {
      selObj.options[i] = null;
    }
    selObj.options.length=null;
    selObj.options[0] = new Option('Select State','');
    selObj.selectedIndex = 0;
  }
  
  //alert('Country=' + document.getElementById('countrySelect').value);
  
  // Populate the drop down with states from the selected country
  var stateLineArray = state.split("|");  // Split into lines
  var optionCntr = 1;
  for (var loop = 0; loop < stateLineArray.length; loop++) {
    lineArray = stateLineArray[loop].split(":");
    countryCode  = TrimString(lineArray[0]);
    stateCode    = TrimString(lineArray[1]);
    stateName    = TrimString(lineArray[2]);
	
  if (document.getElementById('country').value == countryCode && countryCode != '' ) {
    // If it's a input element, change it to a select
      if ( selObj.type == 'text' ) {
        parentObj = document.getElementById('state').parentNode;
        parentObj.removeChild(selObj);
        var inputSel = document.createElement("SELECT");
        inputSel.setAttribute("name","state");
        inputSel.setAttribute("id","state");
        parentObj.appendChild(inputSel) ;
        selObj = document.getElementById('state');
        selObj.options[0] = new Option('Select State','');
        selObj.selectedIndex = 0;
      }
      if ( stateCode != '' ) {
        selObj.options[optionCntr] = new Option(stateName, stateCode);
      }
      // See if it's selected from a previous post
      if ( stateCode == postState && countryCode == postCountry ) {
        selObj.selectedIndex = optionCntr;
      }
      foundState = true;
      optionCntr++
    }
  }
  // If the country has no states, change the select to a text box
  if ( ! foundState ) {
    parentObj = document.getElementById('state').parentNode;
    parentObj.removeChild(selObj);
  // Create the Input Field
    var inputEl = document.createElement("INPUT");
    inputEl.setAttribute("id", "state");
    inputEl.setAttribute("type", "text");
    inputEl.setAttribute("name", "state");
    inputEl.setAttribute("size", 20);
    inputEl.setAttribute("value", postState);
    parentObj.appendChild(inputEl) ;
  }
}

function populateAddrState() {
    var o_addrstateSelect = document.getElementById('addrstateSelect');
 
    var foundState = false;
    // Empty options just in case new drop down is shorter
    if ( o_addrstateSelect.type == 'select-one' ) {
        for (var i = 0; i < o_addrstateSelect.options.length; i++) {
            o_addrstateSelect.options[i] = null;
        }
        o_addrstateSelect.options.length=null;
        o_addrstateSelect.options[0] = new Option('Select State','');
        o_addrstateSelect.selectedIndex = 0;
    }
    // Populate the drop down with states from the selected country
    var v_stateLineArray = state.split("|");  // Split into lines
	
    var v_optionCntr = 1;
	//alert(document.getElementById('addrcountrySelect').value);
    for (var loop = 0; loop < v_stateLineArray.length; loop++) {
        v_lineArray = v_stateLineArray[loop].split(":");
        v_addrcountryCode  = TrimString(v_lineArray[0]);
        v_addrstateCode    = TrimString(v_lineArray[1]);
        v_addrstateName    = TrimString(v_lineArray[2]);
        if (document.getElementById('addrcountrySelect').value == v_addrcountryCode && v_addrcountryCode != '' ) {
            // If it's a input element, change it to a select
            if ( o_addrstateSelect.type == 'text' ) {
                o_parentObj = document.getElementById('addrstateSelect').parentNode;
                o_parentObj.removeChild(o_addrstateSelect);
                var o_inputSel = document.createElement("SELECT");
                o_inputSel.setAttribute("name","addrstate");
                o_inputSel.setAttribute("id","addrstateSelect");
                o_parentObj.appendChild(o_inputSel) ;
                o_addrstateSelect = document.getElementById('addrstateSelect');
                o_addrstateSelect.options[0] = new Option('Select State','');
                o_addrstateSelect.selectedIndex = 0;
            }
			// Load the states into the SELELCT object options
            if ( v_addrstateCode != '' ) {
		        o_addrstateSelect.options[v_optionCntr] = new Option(v_addrstateName, v_addrstateCode);
            }
            // See if it's selected from a previous post
            if ( v_addrstateCode == postState && v_addrcountryCode == postCountry ) {
                o_addrstateSelect.selectedIndex = v_optionCntr;
            }
            foundState = true;
            v_optionCntr++
        }
    }
    //alert(foundState);	
    // If the country has no states, change the select to a text box
    if ( ! foundState ) {
	    //alert('County has no states');
        parentObj = document.getElementById('addrstateSelect').parentNode;
        parentObj.removeChild(o_addrstateSelect);
        // Create the Input Field
        var inputEl = document.createElement("INPUT");
        inputEl.setAttribute("id", "addrstateSelect");
        inputEl.setAttribute("type", "text");
        inputEl.setAttribute("name", "addrstate");
        inputEl.setAttribute("size", 20);
        inputEl.setAttribute("value", postState);
        parentObj.appendChild(inputEl) ;
    }
}

