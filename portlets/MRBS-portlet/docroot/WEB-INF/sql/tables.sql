create table Employee (
	employeeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	employeeName VARCHAR(75) null,
	employeeEmailId VARCHAR(75) null,
	stateId LONG
);

create table IndianState (
	stateId LONG not null primary key,
	stateName VARCHAR(75) null
);

create table PatientDetails (
	patientId LONG not null primary key,
	patientName VARCHAR(75) null,
	patientEmailId VARCHAR(75) null,
	patientAge LONG
);