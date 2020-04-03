use PatientDB;
#Tristin Butz
SET @pat_id_1 = UUID();
#Rachel Krupa
SET @pat_id_2 = UUID();
#Garret Cherry
SET @pat_id_3 = UUID();
#Sabrina Blake
SET @pat_id_4 = UUID();
#Xanax
SET @med_id_1 = UUID();
#Lipitor
SET @med_id_2 = UUID();
#Zoloft
SET @med_id_3 = UUID();
#Valium
SET @med_id_4 = UUID();
SET @visit_id_1 = UUID();
SET @visit_id_2 = UUID();
SET @visit_id_3 = UUID();
SET @visit_id_4 = UUID();

create table Patient(
    patient_id varchar(36) primary key not null,
    patient_first_name varchar(30),
    patient_last_name varchar(30),
    sex char(2)
);
create table Patient_PCP(
    pcp_id int primary key not null auto_increment,
    doctor_first_name varchar(30),
    doctor_last_name varchar(30),
    patient_id varchar(36),
    constraint fk_patient_id_ foreign key(patient_id)
    references Patient(patient_id)
);
create table Patient_Location(
    location_id int primary key not null auto_increment,
    street_number int,
    street_name varchar(30),
    city varchar(30),
    state char(2),
    zip_code varchar(12),
    patient_id varchar(36),
    constraint fk_patient_id foreign key(patient_id)
    references Patient(patient_id)
);
create table medication(
    medication_id varchar(36) primary key not null,
    medication_name varchar(30),
    medication_description varchar(100),
    medication_side_effects varchar(1000),
    medication_directions varchar(1000)
);
create table InsuranceProvider(
    provider_id int primary key not null auto_increment,
    provider_name varchar(30),
    provider_address varchar(50),
    insurance_type varchar(20),
    patient_id varchar(36),
    constraint _fk_patient_id foreign key(patient_id)
    references Patient(patient_id)
);
create table Doctor_Office(
    office_id int primary key not null auto_increment,
    office_name varchar(50),
    office_address varchar(60),
    patient_pcp_id int,
    constraint fk_patient_pcp foreign key(patient_pcp_id)
    references Patient_PCP(pcp_id)
);
#end date, pharmacy where presc sent to, fk_doctor_last_name
create table Prescription (
    patient_id varchar(36) not null,
    medication_id varchar(36) not null,
    prescription_start_date datetime,
    prescription_daily_dosage varchar(36),
    constraint fk_medication foreign key (medication_id)
    references Medication(medication_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    constraint fk_patient foreign key (patient_id) 
    references Patient(patient_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
create table Visit(
    visit_id varchar(36) primary key not null
);
create table Patient_Visit(
    date datetime,
    doctorName varchar(30),
    reasonForVisit varchar(500),
    patient_id varchar(36) not null,
    visit_id varchar(36) not null,
    constraint fk_visit_id foreign key (visit_id)
    references Visit(visit_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    constraint fk_patient_visit foreign key (patient_id) 
    references Patient(patient_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
create table Dx(
    dx_id int primary key not null auto_increment,
    description varchar(1000),
    patient_dx varchar(36),
    patient_visit_dx varchar(36),
    constraint fk_patient_visit_dx foreign key(patient_visit_dx)
    references Visit(visit_id),
    constraint fk_patient_dx foreign key(patient_dx)
    references Patient(patient_id)
    
);
create table Labs(
    lab_id int primary key not null auto_increment,
    bodyweight double,
    height double,
    bloodPressure double,
    bloodType varchar(6),
    bodyTemp double,
    patient_lab varchar(36),
    patient_visit_labs varchar(36),
    constraint fk_patient_visit_labs foreign key(patient_visit_labs)
    references Visit(visit_id),
    constraint fk_patient_lab foreign key(patient_lab)
    references Patient(patient_id)
);
create table Procedures(
    procedure_id int primary key not null auto_increment,
    surgicalHistory varchar(500),
    patient_procedures varchar(36),
    patient_visit_procedures varchar(36),
    constraint fk_patient_visit_procedures foreign key(patient_visit_procedures)
    references Visit(visit_id),
    constraint fk_patient_procedures foreign key(patient_procedures)
    references Patient(patient_id)
    
);
create table Pathology(
    pathology_id int primary key not null auto_increment,
    date datetime,
    testName varchar(30),
    testDescription varchar(100),
    siteCollected varchar(30),
    result varchar(20),
    patient_pathology varchar(36),
    patient_visit_pathology varchar(36),
    constraint fk_patient_visit_pathology foreign key(patient_visit_pathology)
    references Visit(visit_id),
    constraint fk_patient_pathology foreign key(patient_pathology)
    references Patient(patient_id)
);
create table Imaging(
    imaging_id int primary key not null auto_increment,
     scan varchar(30),
     image longblob not null,
     patient_imaging varchar(36),
     patient_visit_imaging varchar(36),
     constraint fk_patient_visit_imaging foreign key(patient_visit_imaging)
     references Visit(visit_id),
     constraint fk_patient_imaging foreign key(patient_imaging)
     references Patient(patient_id)
);

insert into Patient(patient_id, patient_first_name, patient_last_name, sex)
values(@pat_id_1, "Tristin", "Butz", 'M');
insert into Patient(patient_id, patient_first_name, patient_last_name, sex)
values(@pat_id_2, "Rachel", "Krupa", 'F');
insert into Patient(patient_id, patient_first_name, patient_last_name, sex)
values(@pat_id_3, "Garret", "Cherry", 'M');
insert into Patient(patient_id, patient_first_name, patient_last_name, sex)
values(@pat_id_4, "Sabrina", "Blake", 'F');

insert into InsuranceProvider(provider_id, provider_name, provider_address)
values (null, "Aetna", "202 Main St Pittsburgh PA 15214");
insert into InsuranceProvider(provider_id, provider_name, provider_address)
values (null, "UPMC", "204 Main St Pittsburgh PA 15212");
insert into InsuranceProvider(provider_id, provider_name, provider_address)
values (null, "Cigna", "202 Main St Pittsburgh PA 15210");
insert into InsuranceProvider(provider_id, provider_name, provider_address)
values (null, "UPMC For You", "200 Celcius St Pittsburgh PA 15226");

insert into Doctor_Office(office_id, office_name, office_address)
values(null, "Dr. McGann and Associates", "400 W Dover St Pittsburgh PA 15219");
insert into Doctor_Office(office_id, office_name, office_address)
values(null, "Dr. Zel and Associates", "402 W Dover St Pittsburgh PA 15211");
insert into Doctor_Office(office_id, office_name, office_address)
values(null, "Dr. Elivio and Associates", "404 W Dover St Pittsburgh PA 15213");

insert into Patient_PCP(pcp_id, doctor_first_name, doctor_last_name)
values(null, "Dmitry", "McGann");
insert into Patient_PCP(pcp_id, doctor_first_name, doctor_last_name)
values(null, "Han", "Zel");
insert into Patient_PCP(pcp_id, doctor_first_name, doctor_last_name)
values(null, "Gret", "Elivio");
insert into Patient_PCP(pcp_id, doctor_first_name, doctor_last_name)
values(null, "Michealine", "Wilson");

insert into Patient_Location(location_id, street_number, street_name, city, state, zip_code)
values(null, 2506,"Wylie Ave", "Pittsburgh", 'PA', 15219);
insert into Patient_Location(location_id, street_number, street_name, city, state, zip_code)
values(null, 484,"Demoyne St", "Pittsburgh", 'PA', 15210);
insert into Patient_Location(location_id, street_number, street_name, city, state, zip_code)
values(null, 2506,"E Carson", "Pittsburgh", 'PA', 15211);
insert into Patient_Location(location_id, street_number, street_name, city, state, zip_code)
values(null, 25,"Evans Ave", "Ebensburg", 'PA', 15222);

insert into medication(medication_id, medication_name, medication_description, medication_side_effects, medication_directions)
values(@med_id_1, "Xanax", "Anxiety Medication", "Shakes or tremors. Sleeping difficulties. Confusion. Anxiety. Hallucinations. Seizures. Delirium Tremens.", "The orally disintegrating tablet can be taken with or without water. Swallow the extended-release tablets whole; do not chew, crush, or break them. Your doctor will probably start you on a low dose of alprazolam and gradually increase your dose, not more than once every 3 or 4 days. Alprazolam can be habit-forming.");
insert into medication(medication_id, medication_name, medication_description, medication_side_effects, medication_directions)
values(@med_id_2, "Lipitor", "Statin", "A very small number of people taking atorvastatin may have mild memory problems or confusion. If these rare effects occur, talk to your doctor. Rarely, statins may cause or worsen diabetes. Talk to your doctor about the benefits and risks. This drug may rarely cause muscle problems (which can rarely lead to very serious conditions called rhabdomyolysis and autoimmune myopathy). Tell your doctor right away if you develop any of these symptoms during treatment and if these symptoms persist after your doctor stops this drug: muscle pain/tenderness/weakness (especially with fever or unusual tiredness), signs of kidney problems (such as change in the amount of urine).", "Atorvastatin comes as a tablet to take by mouth. It is usually taken once a day with or without food. Take atorvastatin at around the same time every day. Follow the directions on your prescription label carefully, and ask your doctor or pharmacist to explain any part you do not understand.");
insert into medication(medication_id, medication_name, medication_description, medication_side_effects, medication_directions)
values(@med_id_3, "Zoloft", "Depression Medication", "Heart disease, high blood pressure, or a stroke. Liver or kidney disease. Bleeding problems, or if you take warfarin. Seizures. Bipolar disorder (manic depression), or low levels of sodium in your blood.", "Take this medication by mouth as directed by your doctor, usually once daily either in the morning or evening. The tablet or liquid form of this medication may be taken with or without food. The capsule form is usually taken with food.");
insert into medication(medication_id, medication_name, medication_description, medication_side_effects, medication_directions)
values(@med_id_4, "Valium", "Anxiety Medication", "Shakiness, unsteadiness, blurred vision, blistering of the skin, abdominal or stomach pain, chills, confusion, cough, dark urine, decrease in the frequency of urination, nightmares, outbursts of anger, lack of memory, irritability, itching, loss of interest or pleasure, lower back or side pain, pale skin, restlessness, slurred speech, dizziness, fast heartbeat, irregular breathing, feeling sad or empty","Take this medication by mouth with or without food as directed by your doctor. If you are using the liquid form of this medication, carefully measure the dose using a special measuring device/spoon. Do not use a household spoon because you may not get the correct dose.");

insert into Visit(visit_id)
values(@visit_id_1);
insert into Visit(visit_id)
values(@visit_id_2);
insert into Visit(visit_id)
values(@visit_id_3);
insert into Visit(visit_id)
values(@visit_id_4);

insert into Patient_Visit(visit_id, patient_id, date, doctorName, reasonForVisit)
values(@visit_id_1, @pat_id_1, "2016-09-23 10:10:10-08:00", "McGann", "Patient was distraught about recent coronavirus epidemic.");
insert into Patient_Visit(visit_id, patient_id, date, doctorName, reasonForVisit)
values(@visit_id_2, @pat_id_2, "2016-09-23 10:10:10-08:20", "Zel", "Patient was unhappy.");
insert into Patient_Visit(visit_id, patient_id, date, doctorName, reasonForVisit)
values(@visit_id_3, @pat_id_3, "2016-09-23 10:10:10-08:30", "Elivio", "Patient was sad.");
insert into Patient_Visit(visit_id, patient_id, date, doctorName, reasonForVisit)
values(@visit_id_4, @pat_id_4, "2016-09-23 10:10:10-08:40", "Wilson", "Patient was extremely anxious in social environments.");

insert into Prescription(patient_id, medication_id, prescription_start_date, prescription_daily_dosage)
values(@pat_id_1, @med_id_3, '2016-09-23 10:10:10-08:00', "1 per day");
insert into Prescription(patient_id, medication_id, prescription_start_date, prescription_daily_dosage)
values(@pat_id_2, @med_id_2, '2016-09-23 10:16:10-08:00', "1 per day");
insert into Prescription(patient_id, medication_id, prescription_start_date, prescription_daily_dosage)
values(@pat_id_3, @med_id_4, '2016-09-23 10:14:10-08:00', "1 per day");
insert into Prescription(patient_id, medication_id, prescription_start_date, prescription_daily_dosage)
values(@pat_id_4, @med_id_1, '2016-09-23 10:12:10-08:00', "1 per day");

insert into Patient_Visit(visit_id, patient_id)
values(@visit_id_1, @pat_id_1);
insert into Patient_Visit(visit_id, patient_id)
values(@visit_id_2, @pat_id_2);
insert into Patient_Visit(visit_id, patient_id)
values(@visit_id_3, @pat_id_3);
insert into Patient_Visit(visit_id, patient_id)
values(@visit_id_4, @pat_id_4);

insert into Dx(dx_id, description)
values (null, "Tristin was admitted for the coronavirus.");
insert into Dx(dx_id, description)
values (null, "Rachel was admitted for the coronavirus.");
insert into Dx(dx_id, description)
values (null, "Garret was admitted for the coronavirus.");
insert into Dx(dx_id, description)
values (null, "Sabrina was admitted for the coronavirus.");

insert into Labs(lab_id, bodyweight, height, bloodPressure, bloodType, bodyTemp)
values(null, 158.2, 73.0, 102.2, "O-", 98.6);
insert into Labs(lab_id, bodyweight, height, bloodPressure, bloodType, bodyTemp)
values(null, 140.22, 73.0, 102.2, "A+", 98.4);
insert into Labs(lab_id, bodyweight, height, bloodPressure, bloodType, bodyTemp)
values(null, 170.12, 73.0, 102.2, "A-", 98.2);
insert into Labs(lab_id, bodyweight, height, bloodPressure, bloodType, bodyTemp)
values(null, 100.24, 73.0, 102.2, "B-", 98.0);

insert into Procedures(procedure_id, surgicalHistory)
values(null, "Patient underwent skull base surgery to remove a pituitary tumor.");
insert into Procedures(procedure_id, surgicalHistory)
values(null, "Patient had surgery to attach back a filange.");
insert into Procedures(procedure_id, surgicalHistory)
values(null, "Patient underwent a root canal");
insert into Procedures(procedure_id, surgicalHistory)
values(null, "Patient had a kidney stone removed");

insert into Pathology(pathology_id, date, testName, testDescription, siteCollected, result)
values(null, "2016-09-23 10:10:10-08:40", "Biopsy", "Tissue surrounding the brain removed to be tested for cancerous activity", "Brain", "Benine");
insert into Pathology(pathology_id, date, testName, testDescription, siteCollected, result)
values(null, "2016-09-23 10:10:10-08:20", "X-Ray", "An X-ray scan was taken of the digitus medius manus", "Digitus medius manus", "Boxer's Fracture");
insert into Pathology(pathology_id, date, testName, testDescription, siteCollected, result)
values(null, "2016-09-23 10:10:10-08:10", "CT-Scan", "A scan was taken to get location of infected tooth", "Molar", "Root Canal");
insert into Pathology(pathology_id, date, testName, testDescription, siteCollected, result)
values(null, "2016-09-23 10:10:10-08:00", "IVP", "A IVP was given to outline kidneys to find contamination", "Kidney", "Kidney Stone");

update InsuranceProvider
set patient_id = @pat_id_1
where provider_id = 1;
update InsuranceProvider
set patient_id = @pat_id_2
where provider_id = 2;
update InsuranceProvider
set patient_id = @pat_id_3
where provider_id = 3;
update InsuranceProvider
set patient_id = @pat_id_4
where provider_id = 4;

update Patient_Location
set patient_id = @pat_id_1
where location_id = 1;
update Patient_Location
set patient_id = @pat_id_2
where location_id = 2;
update Patient_Location
set patient_id = @pat_id_3
where location_id = 3;

update Patient_PCP
set patient_id = @pat_id_1
where pcp_id = 1;
update Patient_PCP
set patient_id = @pat_id_2
where pcp_id = 2;
update Patient_PCP
set patient_id = @pat_id_3
where pcp_id = 3;
update Patient_PCP
set patient_id = @pat_id_4
where pcp_id = 4;

update Dx
set patient_dx = @pat_id_1
where dx_id = 1;
update Dx
set patient_dx = @pat_id_2
where dx_id = 2;
update Dx
set patient_dx = @pat_id_3
where dx_id = 3;
update Dx
set patient_dx = @pat_id_4
where dx_id = 4;

update Labs
set patient_lab = @pat_id_1
where lab_id = 1;
update Labs
set patient_lab = @pat_id_2
where lab_id = 2;
update Labs
set patient_lab = @pat_id_3
where lab_id = 3;
update Labs
set patient_lab = @pat_id_4
where lab_id = 4;

update Pathology
set patient_pathology = @pat_id_1
where pathology_id = 1;
update Pathology
set patient_pathology = @pat_id_2
where pathology_id = 2;
update Pathology
set patient_pathology = @pat_id_3
where pathology_id = 3;
update Pathology
set patient_pathology = @pat_id_4
where pathology_id = 4;

update Procedures
set patient_procedures = @pat_id_1
where procedure_id = 1;
update Procedures
set patient_procedures = @pat_id_2
where procedure_id = 2;
update Procedures
set patient_procedures = @pat_id_3
where procedure_id = 3;
update Procedures
set patient_procedures = @pat_id_4
where procedure_id = 4;


#                            #
##                          ##
###                        ###
####                      ####
#####                    #####
###### Query Questions! ######
#####                    #####
####                      ####    
###                        ###
##                          ##
#                            #
#1.)How many patients are currently in the database?
select COUNT(patient_id) from Patient;

#2.)What is the first and last name of all patient's who are prescribed Xanax?
select patient_first_name, patient_last_name from Patient p 
inner join Prescription pr on p.patient_id = pr.patient_id
inner join Medication m on pr.medication_id = m.medication_id
where medication_name = 'Xanax';

#3.)What are the medication names in alphabetical order?
select medication_name from medication 
order by medication_name;

#4.)What were the first 4 prescriptions given?
select * from Prescription
limit 4;

#5.)What patients have Dr.McGann and Dr.Wilson as their PCP?
select patient_last_name, patient_first_name from Patient p
left join Patient_PCP pcp on p.patient_id = pcp.patient_id
where doctor_last_name in ("McGann", "Wilson");

#6.)When was the date of the first prescription prescribed to Tristin Butz?
select min(prescription_start_date) from Prescription pr 
join Patient p on pr.patient_id = p.patient_id
where p.patient_first_name = "Tristin" and p.patient_last_name = "Butz";

#7.)Are there any prescriptions you should take once per day?
select count(p.prescription_daily_dosage) from Prescription p 
group by p.prescription_daily_dosage
having prescription_daily_dosage = "1 per day"

#8.)What are the Dx reports for Rachel Krupa?
select * from Dx
where patient_dx = @pat_id_2;

#9.)What patients had a blood type of O-?
select patient_last_name, patient_first_name from Patient p 
join Labs l on p.patient_id = l.patient_lab
where l.bloodType = "O-";

#10.)What are all the patients currently prescribed Valium?
select patient_last_name, patient_first_name from Patient p 
join Prescription pr on p.patient_id = pr.patient_id
join Medication m on pr.medication_id = m.medication_id
where m.medication_name = "Valium";
