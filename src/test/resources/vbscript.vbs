
Dim strLine
Set fso  = CreateObject("Scripting.FileSystemObject")
GetCurrentFolder= fso.GetAbsolutePathName(".")
fullpath = GetCurrentFolder+"\src\test\resources\response.json"
MsgBox (fullpath)
set objFileToRead= fso.OpenTextFile(fullpath,1)

counter=1
Set objExcel = createobject("Excel.Application")  
   excelpath  = GetCurrentFolder+"\src\test\resources\book.xlsx"                           
 objExcel.Workbooks.open(excelpath)    
Set objSheet =objExcel.ActiveWorkbook.Worksheets(1) 

do while not objFileToRead.AtEndOfStream
strLine = objFileToRead.ReadLine()
objSheet.Cells(counter,1).Value=strLine
counter=counter+1
loop
objExcel.ActiveWorkbook.Save
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit                                               
Set objExcel=Nothing      
                           
                            
 
objFileToRead.Close
Set objFileToRead = Nothing
set fso=Nothing
MsgBox ("completed reading from json and writing to excel")

Set objExcel = createobject("Excel.Application")  
                                   
 objExcel.Workbooks.open(excelpath)  
Set objSheet1 =objExcel.ActiveWorkbook.Worksheets(1)  
Set objSheet2 =objExcel.ActiveWorkbook.Worksheets(2) 
rownumber=objSheet1.usedrange.rows.count  
msgbox rownumber

msgbox objSheet1.usedrange.columns.count

 For nRow = 1 To (rownumber)
cellvalue=objSheet1.Cells(nRow,1).Value
objSheet2.Cells(nRow,1).Value=cellvalue

next
objExcel.ActiveWorkbook.Save
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit                                               
Set objExcel=Nothing      

msgbox ("finished reading")

Set objExcel = createobject("Excel.Application")  
                                   
 objExcel.Workbooks.open(excelpath)  
Set objSheet1 =objExcel.ActiveWorkbook.Worksheets(3)  
rownumber=objSheet1.usedrange.rows.count  

colnumber=objSheet1.usedrange.columns.count
dim searchcol
 For colnum = 1 To (colnumber)
cellvalue=objSheet1.Cells(1,colnum).Value
if(Trim(cellvalue)="prakash") Then
searchcol=colnum
MsgBox (searchcol)
 Exit For
End if

next
objExcel.ActiveWorkbook.Save
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit                                               
Set objExcel=Nothing      

msgbox ("finished")