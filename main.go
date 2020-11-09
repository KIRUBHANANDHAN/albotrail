package main

import (
	"bytes"
	"fmt"
	"strings"
	"time"

	"github.com/hyperledger/fabric-chaincode-go/shim"
	pb "github.com/hyperledger/fabric-protos-go/peer"
)

//Doctor JSON object
type Doctor struct {
	ObjectType    string `json:"docType"`
	DocName       string `json:"docname"`
	Address1      string `json:"address"`
	contactNumber int    `json:"contactNumber"`
	Address2      string `json:"Address2"`
	PANNumber     string `json:"PANNumber"`
	AdharNumber   int    `json:"AdharNumber"`
	joiningDate   int    `json:"joiningDate"`
}

//Patient JSON object
type Patient struct {
	ObjectType  string    `json:"docType"`
	SubjectID   int       `json:"SubjectId"`
	PatientID   int       `json:"PatientId"`
	Age         int       `json:"Age"`
	Country     string    `json:"Country"`
	DateOfAdmit time.Time `json:"DateOfAdmit"`
	dob         time.Time `json:"dob"`
	dod         time.Time `json:"dod"`
	dod_hosp    time.Time `json:"dod_hosp"`
	dod_ssn     time.Time `json:"dod_ssn"`
	Email       string    `json:"Email"`
	//    emergency_contact_details int 'json:"emergency_contact_details"'
	ExpireFlag string  `json:"ExpireFlag"`
	Gender     string  `json:"Gender"`
	Height     float64 `json:"Height"`
	//	insurance_details  string 'json:"insurance_details"'
	MaritalStatus string  `json:"MaritalStatus"`
	MobileNumber  int     `json:"MobileNumber"`
	Occupation    string  `json:"Occupation"`
	PatientName   string  `json:"PatientName"`
	RowId         int     `json:"RowId"`
	StatusFlag    bool    `json:"StatusFlag"`
	UserName      string  `json:"UserName"`
	Weight        float64 `json:"Weight"`
	//PRIMARY KEY (subject_id, patient_id)
	//extra parameter, may or maynot use them, this is not present in database schema
	// Address1    string `json:"address"`
	// contactNumber int    `json:"contactNumber"`
	// Address2         string `json:"Address2"`
	// PANNumber        string `json:"PANNumber"`
	// AdharNumber        int `json:"AdharNumber"`
	// joiningDate   int    `json:"joiningDate"`
}

type Ventilator struct {
	ObjectType string `json:"docType"` //docType is used to distinguish the various types of objects in state database
	D1         string `json:"serialNumber"`
	D2         string `json:"assembler"`
	V1         int    `json:"assemblyDate"`
	V2         string `json:"name"`
	V3         string `json:"owner"`
	V4         bool   `json:"recall"`
	recordDate int    `json:"recordDate"`
}

// ===================================================================================
// Main
// ===================================================================================
func main() {
	err := shim.Start(new(VentilatorMachine))
	if err != nil {
		fmt.Printf("Error starting chaincode: %s", err)
	}
}

// Init initializes chaincode
// ===========================
func (t *VentilatorMachine) Init(stub shim.ChaincodeStubInterface) pb.Response {
	return shim.Success(nil)
}

// Invoke - Our entry point for Invocations
// ========================================
func (t *VentilatorMachine) Invoke(stub shim.ChaincodeStubInterface) pb.Response {
	function, args := stub.GetFunctionAndParameters()
	fmt.Println("invoke is running " + function)

	// Handle different functions
	if function == "initDoctor" { //create doctor detail
		return t.initDoctor(stub, args)
	} else if function == "initPatient" { //create initPatient detail
		return t.initPatient(stub, args)
	} else if function == "deleteDoctor" { //delete doctor
		return t.deleteDoctor(stub, args)
	} else if function == "readDoctorDetail" { //read readDoctorDetail
		return t.readDoctorDetail(stub, args)
	} else if function == "readPatientDetail" { //read readPatientDetail
		return t.readPatientDetail(stub, args)
	} else if function == "queryDoctorById" {
		return t.queryDoctorById(stub, args)
	} else if function == "queryPaById" {
		return t.queryPaById(stub, args)
	} else if function == "initVentDetail" {
		return t.initVentDetail(stub, args)
	} else if function == "getVentById" {
		return t.getVentById(stub, args)
	} else if function == "queryVentDetail" {
		return t.queryVentDetail(stub, args)
	}

	fmt.Println("invoke did not find func: " + function) //error
	return shim.Error("Received unknown function invocation")
}

func (t *VentilatorMachine) readDoctorDetail(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	var AdharNumber, jsonResp string
	var err error

	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments.")
	}

	AdharNumber = args[0]
	valAsbytes, err := stub.GetState(AdharNumber)
	if err != nil {
		jsonResp = "{\"Error\":\"Failed to get state for " + AdharNumber + "\"}"
		return shim.Error(jsonResp)
	} else if valAsbytes == nil {
		jsonResp = "{\"Error\":\"doctor does not exist: " + AdharNumber + "\"}"
		return shim.Error(jsonResp)
	}

	return shim.Success(valAsbytes)
}

func (t *VentilatorMachine) readPatientDetail(stub shim.ChaincodeStubInterface, args []string) pb.Response {
	var AdharNumber, jsonResp string
	var err error

	if len(args) != 1 {
		return shim.Error("Incorrect number of arguments.")
	}

	AdharNumber = args[0]
	valAsbytes, err := stub.GetState(AdharNumber)
	if err != nil {
		jsonResp = "{\"Error\":\"Failed to get state for " + AdharNumber + "\"}"
		return shim.Error(jsonResp)
	} else if valAsbytes == nil {
		jsonResp = "{\"Error\":\"patient does not exist: " + AdharNumber + "\"}"
		return shim.Error(jsonResp)
	}

	return shim.Success(valAsbytes)
}

func (t *VentilatorMachine) getVentilatordataByRange(stub shim.ChaincodeStubInterface, args []string) pb.Response {

	if len(args) < 2 {
		return shim.Error("Incorrect number of arguments. Expecting 2")
	}

	startKey := args[0]
	endKey := args[1]

	resultsIterator, err := stub.GetStateByRange(startKey, endKey)
	if err != nil {
		return shim.Error(err.Error())
	}
	defer resultsIterator.Close()

	// buffer is a JSON array containing QueryResults
	var buffer bytes.Buffer
	buffer.WriteString("[")

	bArrayMemberAlreadyWritten := false
	for resultsIterator.HasNext() {
		queryResponse, err := resultsIterator.Next()
		if err != nil {
			return shim.Error(err.Error())
		}
		// Add a comma before array members, suppress it for the first array member
		if bArrayMemberAlreadyWritten == true {
			buffer.WriteString(",")
		}
		buffer.WriteString("{\"Key\":")
		buffer.WriteString("\"")
		buffer.WriteString(queryResponse.Key)
		buffer.WriteString("\"")

		buffer.WriteString(", \"Record\":")
		// Record is a JSON object, so we write as-is
		buffer.WriteString(string(queryResponse.Value))
		buffer.WriteString("}")
		bArrayMemberAlreadyWritten = true
	}
	buffer.WriteString("]")

	fmt.Printf("- getVehiclePartByRange queryResult:\n%s\n", buffer.String())

	return shim.Success(buffer.Bytes())
}

func (t *VentilatorMachine) queryPatient(stub shim.ChaincodeStubInterface, args []string) pb.Response {

	if len(args) < 1 {
		return shim.Error("Incorrect number of arguments. Expecting 1")
	}

	owner := strings.ToLower(args[0])

	queryResults, err := getQueryResultForQueryString(stub, queryString)
	if err != nil {
		return shim.Error(err.Error())
	}
	return shim.Success(queryResults)
}

// func (t *AutoTraceChaincode) queryDoctorById(stub shim.ChaincodeStubInterface, args []string) pb.Response {

// 	//   0
// 	// "queryString"
// 	if len(args) < 1 {
// 		return shim.Error("Incorrect number of arguments. Expecting 1")
// 	}

// 	queryString := args[0]

// 	queryResults, err := getQueryResultForQueryString(stub, queryString)
// 	if err != nil {
// 		return shim.Error(err.Error())
// 	}
// 	return shim.Success(queryResults)
// }

// =========================================================================================
// getQueryResultForQueryString executes the passed in query string.
// Result set is built and returned as a byte array containing the JSON results.
// =========================================================================================
func getQueryResultForQueryString(stub shim.ChaincodeStubInterface, queryString string) ([]byte, error) {

	fmt.Printf("- getQueryResultForQueryString queryString:\n%s\n", queryString)

	resultsIterator, err := stub.GetQueryResult(queryString)
	if err != nil {
		return nil, err
	}
	defer resultsIterator.Close()

	// buffer is a JSON array containing QueryRecords
	var buffer bytes.Buffer
	buffer.WriteString("[")

	bArrayMemberAlreadyWritten := false
	for resultsIterator.HasNext() {
		queryResponse, err := resultsIterator.Next()
		if err != nil {
			return nil, err
		}
		// Add a comma before array members, suppress it for the first array member
		if bArrayMemberAlreadyWritten == true {
			buffer.WriteString(",")
		}
		buffer.WriteString("{\"Key\":")
		buffer.WriteString("\"")
		buffer.WriteString(queryResponse.Key)
		buffer.WriteString("\"")

		buffer.WriteString(", \"Record\":")
		// Record is a JSON object, so we write as-is
		buffer.WriteString(string(queryResponse.Value))
		buffer.WriteString("}")
		bArrayMemberAlreadyWritten = true
	}
	buffer.WriteString("]")

	fmt.Printf("- getQueryResultForQueryString queryResult:\n%s\n", buffer.String())

	return buffer.Bytes(), nil
}

// ===========================================================================================
// getHistoryForRecord returns the histotical state transitions for a given key of a record
// ===========================================================================================
// func (t *AutoTraceChaincode) getHistoryForRecord(stub shim.ChaincodeStubInterface, args []string) pb.Response {

// 	if len(args) < 1 {
// 		return shim.Error("Incorrect number of arguments. Expecting 1")
// 	}

// 	recordKey := args[0]

// 	fmt.Printf("- start getHistoryForRecord: %s\n", recordKey)

// 	resultsIterator, err := stub.GetHistoryForKey(recordKey)
// 	if err != nil {
// 		return shim.Error(err.Error())
// 	}
// 	defer resultsIterator.Close()

// 	// buffer is a JSON array containing historic values for the key/value pair
// 	var buffer bytes.Buffer
// 	buffer.WriteString("[")

// 	bArrayMemberAlreadyWritten := false
// 	for resultsIterator.HasNext() {
// 		response, err := resultsIterator.Next()
// 		if err != nil {
// 			return shim.Error(err.Error())
// 		}
// 		// Add a comma before array members, suppress it for the first array member
// 		if bArrayMemberAlreadyWritten == true {
// 			buffer.WriteString(",")
// 		}
// 		buffer.WriteString("{\"TxId\":")
// 		buffer.WriteString("\"")
// 		buffer.WriteString(response.TxId)
// 		buffer.WriteString("\"")

// 		buffer.WriteString(", \"Value\":")
// 		// if it was a delete operation on given key, then we need to set the
// 		//corresponding value null. Else, we will write the response.Value
// 		//as-is (as the Value itself a JSON vehiclePart)
// 		if response.IsDelete {
// 			buffer.WriteString("null")
// 		} else {
// 			buffer.WriteString(string(response.Value))
// 		}

// 		buffer.WriteString(", \"Timestamp\":")
// 		buffer.WriteString("\"")
// 		buffer.WriteString(time.Unix(response.Timestamp.Seconds, int64(response.Timestamp.Nanos)).String())
// 		buffer.WriteString("\"")

// 		buffer.WriteString(", \"IsDelete\":")
// 		buffer.WriteString("\"")
// 		buffer.WriteString(strconv.FormatBool(response.IsDelete))
// 		buffer.WriteString("\"")

// 		buffer.WriteString("}")
// 		bArrayMemberAlreadyWritten = true
// 	}
// 	buffer.WriteString("]")

// 	fmt.Printf("- getHistoryForRecord returning:\n%s\n", buffer.String())

// 	return shim.Success(buffer.Bytes())
// }
