drop table Appointments;
drop table Centers;
drop table CenterTypes;

create table CenterTypes(
	Id int not null,
	Name nvarchar(500) not null,
	Primary Key(Id)
);
insert into CenterTypes values (1, "Transport Canada owned and operated / Détenu et exploité par Transport Canada");
insert into CenterTypes values (2, "Authorized Examination Invigilators / Surveillant d'examen autorisés");

CREATE TABLE Centers(
	Id	int	not null,
	Name nvarchar(500) NOT NULL,
	StreetAddress nvarchar(500) NOT NULL,
	CenterTypeId int NOT NULL,
	Primary Key(Id),
	FOREIGN KEY(CenterTypeId) REFERENCES CenterTypes(Id)
);

Create table Appointments(
	Id int not null,
	ClientFullName nvarchar(500) not null,
	AppointmentDate nvarchar(500) not null,
	CenterId int not null,
	Primary Key(Id),
	FOREIGN KEY(CenterId) REFERENCES Centers(Id)	
);

insert into centers values(1, 'Transport Canada', 'Flight Crew Examinations\n        330 Sparks Street\n        Place de Ville, Tower C, 6th Floor\n        Ottawa, ON\n        K1A 0N8\n        Telephone: 613-990-6077', 1);
insert into centers values(2, 'Atlantic Regional Office', 'Heritage Court\n        95 Foundry Street\n        Moncton, NB\n        E1C 8K6\n        Telephone: 506-851-7131', 1);
insert into centers values(3, 'St. John''s Transport Canada Centre', 'John Cabot Building\n        10 Barter''s Hill\n        P.O. Box 1300\n        St. John''s, NL\n        A1C 6H8\n        Telephone: 709-772-3307', 1);
insert into centers values(4, 'Dartmouth Transport Canada Centre', 'Office, Queen Square\n        Darthmouth, NS\n        B2Y 2N6\n        Telephone: 1-800-305-2059', 1);
insert into centers values(5, 'Ontario Regional Office', '4900 Yonge Street\n        4th Floor\n        Toronto, ON\n        M2N 6A5\n        Telephone: 416-952-0230', 1);
insert into centers values(6, 'Hamilton Transport Canada Centre', 'Hamilton Airport\n        9300 Airport Road - Unit 450\n        Mount Hope, ON\n        L0R 1W0\n        Telephone: 905-679-3477', 1);
insert into centers values(7, 'Sarnia Transport Canada Centre', '100 Front Street South\n        Sarnia, ON\n        N7T 2M4\n        Telephone: 519-464-5111', 1);
insert into centers values(8, 'Ottawa Transport Canada Centre', '39 Camelot Drive, Suite 400\n        Nepean, ON\n        K2G 5W6\n        Telephone: 613-952-1637', 1);
insert into centers values(9, 'Sudbury Transport Canada Centre', '3101 Skyline Drive\n        Sudbury Airport\n        Garson, ON\n        P3L 1V4\n        Telephone: 705-693-5804', 1);
insert into centers values(10, 'Thunder Bay Transport Canada Centre', 'Airport Terminal Building\n        2nd Floor\n        210 - 100 Princess Street\n        Thunder Bay, ON\n        P7E 6S2\n        Telephone: 807-474-2570', 1);
insert into centers values(11, 'Pacific Regional Office', '800 Burrard Street, Suite 810\n        Vancouver, BC\n        V6Z 2J8\n        Telephone: 604-666-5571', 1);
insert into centers values(12, 'Abbotsford Transport Canada Centre', '103 - 1785 Clearbrook Road\n        Abbotsford, BC\n        V2T 5X5\n        Telephone: 604-504-4650', 1);
insert into centers values(13, 'Kelowna Transport Canada Centre', '#4 - 5583 Airport Way\n        Kelowna, BC\n        V1V 1S1\n        Telephone: 250-491-3700', 1);
insert into centers values(14, 'Richmond Transport Canada Centre', '400 - 3600 Lysander Lane\n        Richmond, BC\n        V7B 1C3\n        Telephone: 604-666-8777', 1);
insert into centers values(15, 'Prince George Transport Canada Centre', '#350 - 177 Victoria Street\n        Prince George, BC\n        V2L 5R8\n        Telephone: 250-561-5294', 1);
insert into centers values(16, 'Victoria Transport Canada Centre', '103 - 1962 Canso Road\n        North Saanich, BC\n        V8L 5V5\n        Telephone: 250-363-6823', 1);
insert into centers values(17, 'Prairie and Northern Regional Office', 'Canada Place\n        1100 - 9700 Jasper Avenue\n        Edmonton, AL\n        T5J 4E6\n        Telephone: 1-888-463-0521', 1);
insert into centers values(18, 'Whitehorse Transport Canada Centre', 'Room 105-300 Main Street\n        Whitehorse, YT\n        Y1A 2B5\n        Telephone: 1-888-463-0521', 1);
insert into centers values(19, 'Saskatoon Transport Canada Centre', '4 - 2625 Airport Dr\n        Saskatoon, SK\n        S7L 7L1\n        Telephone: 1-888-463-0521', 1);
insert into centers values(20, 'Yellowknife Transport Canada Centre', '4915 - 48 Street\n        3rd Floor, YK Centre East\n        P.O. Box 1439\n        Yellowknife, NT\n        X1A 2P1\n        Telephone: 1-888-463-0521', 1);
insert into centers values(21, 'Winnipeg Transport Canada Centre', '344 Edmonton Street - 2nd Floor\n        P.O. Box 8550\n        Winnipeg, MB\n        R3C 0P6\n        Telephone: 1-888-463-0521', 1);
insert into centers values(22, 'Calgary Transport Canada Centre', '800-1601 Airport Road, N.E.\n        Calgary, Alberta\n        T2E 8W3\n        Telephone: 1-888-463-0521', 1);
insert into centers values(23, 'Québec Regional Office', '700, rue Leigh Capréol\n        2nd Floor, Room 2001\n        Dorval, QC\n        Telephone: 514-633-3863\n        Toll Free Number: 1-800-305-2059', 1);
insert into centers values(24, 'Québec Transport Canada Centre', '401-1550, av. D''Estimauville\n        2800, avenue St-Jean Baptiste, Room 250\n        Québec, QC\n        G2E 6J5\n        Telephone: 418-877-1765\n        Toll Free Number: 1-800-305-2059', 1);
insert into centers values(25, 'Alma Transport Canada Centre', 'Aviation civile\n        100, rue St-Joseph, Suite 6\n        Alma, QC\n        G8B 7A6\n        Telephone: 1-800-305-2059', 1);
insert into centers values(26, 'Sept-Iles Transport Canada Centre', 'Marine Security\n        701, boulevard Laure\n        Suite 205, 2nd Floor\n        P.O. Box 596\n        Sept-Iles, QC\n        G4R 4K7\n        Local number: 418-968-4991 / Toll free number: 1-877-303-3435', 1);
insert into centers values(27, 'Longueuil Transport Canada Centre', '1111, Saint-Charles Ouest\n        Suite 356, Tour Est\n        Longueuil, QC\n        J4K 5G4\n        Toll free: 1-800-305-2059', 1);
insert into centers values(28, 'Rimouski Transport Canada Centre', 'Marine Security\n        180, rue de la Cathédrale\n        Rimouski, QC\n        G5L 5H9\n        Local: 418-722-3040 / Toll free: 1-800-427-4417', 1);
insert into centers values(29, 'Wendi Jane Lunney', 'Canlink Aviation Inc.\n        (Moncton Flight College)\n        2570 Route 102 Hwy, Unit 7\n        Lincoln, NB\n        E3B 9G1\n        Telephone: 506-357-3787', 2);
insert into centers values(30, 'Tracy Lynn Gunter / Carey Taylor', 'Canlink Aviation Inc.\n        (Moncton Flight College)\n        1719 Champlain Street\n        Dieppe, NB\n        E1A 7P5\n        Telephone: 506-857-3080', 2);
insert into centers values(31, 'Sadie Marie', 'Exploits Valley Air Services Ltd.\n        PO Box 355\n        Gander, NL\n        A1V 1W7\n        Telephone: 709-256-7484', 2);
insert into centers values(32, 'William Mark Blake', 'Lab West Ultralight\n        851 Tamarack Drive\n        Labrador City, NL\n        A2V 2M4\n        Telephone: 709-944-4080', 2);
insert into centers values(33, 'Pierre Charles Ouellette', 'Grand Falls Aviation Services Ltd.\n        3 Michaud Road\n        Grand Falls, NB\n        E3Z 1L5\n        Telephone: 506-473-2566', 2);
insert into centers values(34, 'Stuart Lemoine Fairchild / Paul Gamble', 'Truro Flying Club\n        P.O. Box 242\n        Debert, NS\n        B0M 1G0\n        Telephone: 902-662-2228', 2);
insert into centers values(35, 'Ian Malcolm Fyfe', 'St. Thomas Flight Centre Ltd\n        44989 Talbot Line, R.R. #3\n        St. Thomas, ON\n        N5P 3S7\n        Telephone: 519-637-8359', 2);
insert into centers values(36, 'Kathryn Mary Small / David Gordon Small', 'Cornwall Aviation (1979) Ltd.\n        19403 Airport Rd.\n        R.R. #1\n        Summerstown, ON\n        K0C 2E0\n        Telephone: 613-931-3311', 2);
insert into centers values(37, 'Brenda Reid / Marie-Eve Richard', 'Rockcliff Flying Club (1961)\n        Ottawa Rockliffe Airport\n        1495 Rockcliffe Parkway\n        Ottawa, ON\n        K1L 4Y5\n        Telephone: 613-746-4425', 2);
insert into centers values(38, 'Shawn Ronald Broughton', 'Brantford Flying Club\n        Box 903\n        Brantford, ON\n        N3T 5S1\n        Telephone: 519-753-2521', 2);
insert into centers values(39, 'Daniel Richard Vachon', 'Owen Sound Flight Services Inc.\n        203807 Highway #26, R.R. #8\n        Owen Sound, ON\n        N4K 5W4\n        Telephone: 519-372-1259', 2);
insert into centers values(40, 'David Marks / Jose Goncalves', 'Midland Flight Centre Ltd.\n        P.O. Box 307\n        Collingwood, ON\n        L9Y 3Z4\n        Telephone: 705-446-1139', 2);
insert into centers values(41, 'Robert Lou Carney / Judy Piccioni / Valecia Gulcharan', 'Brampton Flying Club\n        13691 McLaughlin Road\n        P.O. Box 27 Stn. Cheltenham\n        Caledon, ON\n        L7C 3L7\n        Telephone: 416-798-7928', 2);
insert into centers values(42, 'Cindy Masse / Denis Hamelin', 'Windsor Flying Club Inc.\n        Unit 105\n        2600 Airport Road\n        Windsor, ON\n        N8V 1A1\n        Telephone: 519-969-1320', 2);
insert into centers values(43, 'Richard McIntyre / Mathew Scheben', 'Waterloo-Wellington Flight Centre\n        4881 Fountain Street North, Unit #3\n        Bresleau, ON\n        N0B 1M0\n        Telephone: 519-648-2213', 2);
insert into centers values(44, 'John Stuart Brake', 'York Soaring Association\n        7296 5th Line R.R. #1\n        Belwood, ON\n        N0B 1J0\n        Telephone: 519-848-3621', 2);
insert into centers values(45, 'Michael Kerr Hill', 'Kingston Flying Club\n        Norman Rogers Airport\n        Kingston, ON\n        K7M 9A1\n        Telephone: 613-389-0954', 2);
insert into centers values(46, 'Sabine Lohrbach', 'Fly Canadian\n        2187 Hwy. 35 North\n        Lindsay, ON\n        K9V 4R1\n        Telephone: 705-879-4206', 2);
insert into centers values(47, 'Lawrence Edward Lee', 'Genesis Flight Centre Inc.\n        P.O. Box 312\n        Collingwood, ON\n        L9Y 3Z7\n        Telephone: 877-359-3245', 2);
insert into centers values(48, 'Colette Cecile Morin', 'C. Morin Aviation (BC) Inc.\n        Glacier Air\n        P.O. Box 2014\n        Squamish Airport, BC\n        V8B 0B4\n        Telephone: 604-898-9016', 2);
insert into centers values(49, 'Patricia Anne Kennedy', 'Pacific Flying Club\n        #4 â€“ 4335 Skeena St.\n        Delta, BC\n        V4K 0A6\n        Telephone: 604-946-0011', 2);
insert into centers values(50, 'Gerry Mants / Marcel Poland', 'Victoria Flying Club\n        #101 - 1852 Canso Road\n        North Saanich, BC\n        V8L 5V5\n        Telephone: 250-656-4321', 2);
insert into centers values(51, 'Randell Kuan / Diana Kuan', 'International Flight Centre Inc.\n        Unit #1 â€“ 7630 Montreal Street\n        Delta, BC\n        V4K 0A7\n        Telephone: 604-940-6383', 2);
insert into centers values(52, 'DavId Lloyd Parry / Rita Maria Alida Methorst', 'Langley Flying School Inc.\n        Unit 219 - 5333 - 216th Street\n        Langley, BC\n        V3A 4R1\n        Telephone: 604-532-6461', 2);
insert into centers values(53, 'Shannon Helena Meissner', 'Pacific Professional Flight Centre Ltd.\n        Unit 6 - 4340 King Street\n        Delta, BC\n        V4K 0A5\n        Telephone: 604-952-4635', 2);
insert into centers values(54, 'Ronald Bradley Reynolds', 'Skyquest Aviation Ltd.\n        Hangar #1 â€“ 5333 â€“ 216 Street\n        Langley, BC\n        V2Y 2N3\n        Telephone: 604-534-6855', 2);
insert into centers values(55, 'Bobbi Stout', 'Coastal Pacific Aviation Ltd.\n        30575 Approach Drive\n        Abbotsford, BC\n        V2T 6H5\n        Telephone: 604-855-1112', 2);
insert into centers values(56, 'Marc Anthony Vanderaegen', 'Sourthern Interior Flight center (1993) Ltd.\n        6191 Airport Way\n        Kelowna, BC\n        V1V 2S2\n        Telephone: 250-878-5800', 2);
insert into centers values(57, 'Judi Louise Chambers', 'Lawrence Aviation Ltd.\n        P.O. Box 4418\n        Williams Lake, BC\n        V2G 2V4\n        Telephone: 250-392-3195', 2);
insert into centers values(58, 'Ida Leung', 'Sea Land Air Management Ltd.\n        Aberdeen Centre\n        Unit 2010 - 4151 Hazelbridge Way\n        Richmond, BC\n        V6X 4J7\n        Telephone: 604-295-8176 Ext. 1108', 2);
insert into centers values(59, 'Tyler John Gertzen', 'Tylair Aviation Ltd.\n        2845 Aviation Way\n        Kamloops, BC\n        V2B 7Y2\n        Telephone: 250-554-3333', 2);
insert into centers values(60, 'Peter Schlieck', 'Canadian Flight Centre Inc.\n        101 â€“ 7500 Ottawa St.\n        Delta, BC\n        V4K 0B4\n        Telephone: 604-946-7744', 2);
insert into centers values(61, 'Taylor Williams / Sophie Peschard', 'Pacific Sky Aviation Inc.\n        1533 Kitty Hawk Rd.\n        North Saanich, BC\n        V8L 5V6\n        Telephone : 250-656-4312', 2);
insert into centers values(62, 'Véronique Ouellet', 'A.L.M. Par Avion Inc.\n        3415, Chemin de l''aéroport, porte 3\n        Mascouche (Québec)\n        J7K 3C1\n        Telephone: 450-474-0975', 2);
insert into centers values(63, 'Thierry Rene Pierre Dugrippe', 'Air Richelieu\n        5800 Route de l''aéroport\n        St-Hubert (Québec)\n        J3Y 8Y9\n        Telephone: 452-445-4444', 2);
insert into centers values(64, 'Laurette Grenier', 'Grondair\n        2075 Route 112\n        St-Frédéric de Beauce (Québec)\n        G0N 1P0\n        Telephone: 418-426-2313', 2);
insert into centers values(65, 'Candace Morrow', 'Lachute Aviation\n        480 Boulevard de l''aéroparc\n        Lachute (Québec)\n        J8H 3R8\n        Telephone: 450-562-1330', 2);
insert into centers values(66, 'Ginette Héroux', 'Nadeau Air Service Inc.\n        3300, Aéroport de Trois-RiviÃ¨res\n        Trois-Rivières (Québec)\n        G9A 5E1\n        Telephone : 819-377-4387', 2);
insert into centers values(67, 'Pierre Etienne Geneau De LamarliÃ¨re', 'Aéro Loisirs Inc.\n        144 Chemin Roger Hébert\n        La Macaza Québec)\n        J0T 1R0\n        Telephone : 819-275-1597', 2);
insert into centers values(68, 'Bassima Melki', 'École de Pilotage Saint-Hubert Inc.\n        5680 Chemin de l''Aéroport\n        St-Hubert (Québec)\n        J3Y 8Y9\n        Telephone : 450-443-4555', 2);
insert into centers values(69, 'Tina Bertrand', 'École de Pilotage de L''Abitibi-Témiscamingue Inc.\n        42 7E Rue (hagar Q-60) Suite 2\n        Val D''Or (Québec)\n        J9P 0G6\n        Telephone: 819-354-2255', 2);
insert into centers values(70, 'Sherry Diane Cooper / Steward John Vanmale', 'Sky Wings Aviation Academy Ltd.\n        P.O. Box 190\n        Penhold, AB\n        T0M 1R0\n        Telephone: 403-886-5191', 2);
insert into centers values(71, 'Thomas Gibson Ray / David Neil Atkinson', 'Regina Flying Club (1944)\n        2610 Airport Road\n        Regina, SK\n        S4W 1A3\n        Telephone: 306-525-6194', 2);
insert into centers values(72, 'James Ernest Smith', 'Centennial Flight Centre Inc.\n        Hanger 17, Villeneuve Airport\n        26-27018, SH633\n        Sturgeon Country, AB\n        T8T 0E3\n        Telephone: 780-451-7676', 2);
insert into centers values(73, 'Donald Austin George Ingham / Brenda Ann Ingham', 'Leading Edge Aviation Ltd.\n        P.O. Box 1477\n        Yorkton, SK\n        S3N 3G3\n        Telephone: 306-783-0321', 2);
insert into centers values(74, 'Greg Penner / Adam Penner', 'Harv''s Air Service Ltd.\n        Box 1056\n        Steinback, MB\n        R5G 1M8\n        Telephone: 204-326-2434', 2);
insert into centers values(75, 'Jordan Kroeker', 'Hav''s Air Services Ltd.\n        St. Andrews Airport\n        601 Unit Road, Unit 100 St. Andrews, MB\n        R1A 3P6\n        Telephone: 204-339-6186', 2);
insert into centers values(76, 'Wade Michael Komarnisky', 'McMurray Aviation\n        Site 1 Box 5 RR1\n        Fort McMurray, AB\n        T9H 5B4\n        Telephone: 780-791-2182', 2);
insert into centers values(77, 'Marcus Seitter', 'Brandon Flying Club\n        Site 520, P.O. Box 18, RR#5\n        Brandon, MB\n        R7A 5Y5\n        Telephone: 204-728-7691', 2);
insert into centers values(78, 'Michael Mario Mohr', 'Adventure Aviation Inc.\n        7117 102 Street\n        Grande Prairie, AB\n        T8W 2R8\n        Telephone: 780-539-6968', 2);
insert into centers values(79, 'Dale Edward Tiedeman / Cathryn Rose Lawrence', 'Mitchinson Flying Service Limited\n        P.O. Box 1521\n        Saskatoon, SK\n        S7K 3R3\n        Telephone: 306-244-6714', 2);
insert into centers values(80, 'Jacqui Shaw', 'The Prairie Bible Institute\n        Box 4000\n        Three Hills, AB\n        T0M 2N0\n        Telephone: 403-443-2349', 2);
insert into centers values(81, 'Sonette Tredoux', 'Calgary Flying Club\n        155A MacLaurin Drive\n        Calgary, AB\n        T3Z 3S4\n        Telephone: 403-288-8831', 2);
insert into centers values(82, 'Sheena Kristy Bennett / Christopher John Ueland / Chandler John Cook', 'Excel Flight Training Incorporated\n        Suite 201, 421 Stubb Ross Road\n        Lethbridge, AB\n        T1K 7N3\n        Telephone: 403-329-4887', 2);
insert into centers values(83, 'Orville Hewitt / Benjamin Lee Match', 'Cooking Lake Aviation Academy Inc.\n        69, 51401 Range Rd 221\n        Sherwood Park, AB\n        T8E 1H1\n        Telephone: 780-922-2802', 2);
insert into centers values(84, 'Ronald Vanden Dungen / Steven Travis Dammann', 'Wetaskiwin Air Services Ltd.\n        Box 6444\n        Wetaskiwin, AB\n        T9A 2G2\n        Telephone: 780-352-5643', 2);
insert into centers values(85, 'Jayme Joel Hepfner / Eden Elizabeth Vogan', 'Springbank Air Training College Ltd.\n        132 MacLaurin Drive\n        Calgary, AB\n        T3Z 3S4\n        Telephone: 403-288-7700', 2);
insert into centers values(86, 'Robert John Smits / Erin Hyderman', 'Namao Flying Club\n        25, 27018 S.H. 633\n        Sturgeon Country, AB\n        T8T 0E3\n        Telephone: 780-419-6777', 2);
insert into centers values(87, 'Steven James Watt', 'Border City Aviation Ltd.\n        Box 963\n        Lloydminster, SK\n        T9V 3B3\n        Telephone: 780-875-5834', 2);
insert into centers values(88, 'Benjamin Gerzen', 'Mountain City Aviation Inc.\n        50 Conner Hill Drive\n        Morden, MB\n        R6M 1J1\n        Telephone: 204-822-9621', 2);
insert into centers values(89, 'Terri Ann Super', 'Super T Management LTD.\n        #11, 49 Viscount Ave SW\n        Medicine Hat, AB\n        T1A 5G4\n        Telephone: 403-548-6636', 2);
insert into centers values(90, 'Daniel Edgar Reeves', 'Winnipeg Aviation (2003) LTD.\n        700 South Gate Road\n        St. Andrews, MB\n        R1A 3P8\n        Telephone: 204-338-7923', 2);
