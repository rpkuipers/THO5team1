bieden werkt niet, ik denk dat het amount niet uit de jsp word uitgelezen.


--------------------------------------------------------------------
(LEAVE HERE PLEASE)
statistieken?
sprint - schrijven naar databases, niet alles gekoppeld, pop in retrospective
buyoutprice in 2e constructor aangezien dit niet verplicht is
startdate mag niet later zijn dan enddate
does auction dissapear if it's finished? or does it stay in user account - thread!
what happens when 2 people use the same account and bid at the same time on 2 different products
tempcredits moet nog!!!
kan user remove bid doen?

<------------TODO----------->
-Categorie aan auction
-Bieden
-Start&begindatum bij auction
-Enkele auction page

MUST:
Menu options
Coworker:
-Block/unblock user (role = 0)
-Block/unblock auction (active = false)
-Userlist

Admin:
-Block/unblock user (role = 0)
-Block/unblock auction (active = false)
-Add/remove coworker
-Remove user
-Add categories
-Userlist

2x user met zelfde id toevoegen mag niet. (Generate ID automatically?)
Wachtwoord mg niet hetzelfde zijn als de gebruikersnaam.
Categorie mag niet 2 keer toegevoegd worden.
Ability to give user +1 (points)

Could/would:
add company bij attributen User (niet verplicht)
Ability to give a user a review
ISBN Validation bij boek categorie
User kan bid terugtrekken
User watcht product en biedt dus niet
<------------TODO----------->


<-----------WEBPAGES---------->
USER ACCOUNT:
with button change user information, with message hello user {name}
name, address, username, password, newPassword PasswordRepeat, email, phoneNumber (restriction 10 karakters), credits is 0 at registration
in account user can view auctions (list) which he has bidded in
in account user can create a new auction (title, productname, description, startprice, buyoutprice, entrydate, startdate, enddate)

AUCTIONS & SEARCHES
search for auction, only that searched auction appears on page, also user name whose auction it is
Search for auction category, only auctions in that category are shown
Search for auction subcategory, only auctions in that subcategory are shown
all auctions page
new auctions page
auction subcategory page (for instance Antiques --> Silver)
auction category page (for instance Antiques)

BIDs:
User can bid on product on auction page (button and textfield)
bid is added to bid list, name and amount is next to auction
<-----------WEBPAGES---------->
