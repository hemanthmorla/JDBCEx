'* This macro is used to keep the system active for the specified number of minutes - Lee


Dim Input
Input = InputBox("Enter Number of minutes to be active: ") 

'* If the user doesn't want to proceed - quit
If Input = "" Then 
   WScript.quit() 
End If 

'* If the user doesn't enter valid number of minutes - default to 5 minutes
If Not IsNumeric(Input) Then Input = 5

MsgBox ("Your system will be active for " & Input & " minutes")

set Keepactive = CreateObject("WScript.Shell")

For i = 1 To Input
    WScript.Sleep (60*1000)
    Keepactive.SendKeys ("{NUMLOCK 2}")
Next

MsgBox ("Thank you for using the script!")

'* Use this script for only learnign purpose!