a = 11
b = 6

a,b = b,a

a = a + b #17
b = a - b #11
a = a - b #6

#abbccbba

def palindrome(text):
	t = "" #abbccbba
	for i in text:
		t = i + t
	if(t==text):
		return true
	else:
		return false

	#another approach
	reverse = text[::-1]
	if(reverse==text):
		return true
	else:
		return false


deatils = {"name": "JhonCage", "age": 42, "city": "New York", "location":{"Street": "Newyard", "pin": 42, "flat": "91"}, "pets":["Parrot", "dog"]}

name = JhonCage {string}
age = 24
city = NewYork
location
    street = Newyard
    pin = 42
    flat = 91
pets
   parrot
   dog		

def print_dict(dict):
	for key,value in dict.items():
		if(type(value) == dict || type(value) == list || type(value)==tuple):
			print(key)
			print_dict(value)
		else:
			print(key + "=" + value + "{" +type(value) +"}")

#########################

curl -H "X-JFrog-Art-Api:AKCp2V77AUU7YsftCPk" -X POST http://10.x.x.x:8081/artifactory/api/users
FN LN Email Role
arjun prasad arjunk@mycompany.com developer
ravi kumar ravik@mycompany.com developer


from urllib.request import Request, urlopen

req = Request(url="http://10.x.x.x:8081/artifactory/api/users",headers={"Authorizaiton":"X-JFrog-Art-Api:AKCp2V77AUU7YsftCPk"}, method="POST")
response = urlopen(req).read()
if(response):
	data = json.loads(response)
	htmldata = '''<html>
	<head>
		<title> Artifactory users </title>
	</head>
	<body>
	<table>
		<tr>
			<th> FN </th>
			<th> LN </th>
			<th> Email </th>
			<th> Role </th>
		</tr>
	'''
	for i in range(len(data)):
		htmldata = htmldata + "<tr><td>" + data[i]["FN"] + "</td>"
		htmldata += "<td>" + data[i]["LN"] + "</td>" 
		htmldata += "<td>" + data[i]["Email"] + "</td>" 
		htmldata += "<td>" + data[i]["Role"] + "</td> </tr>" 
		#print(data[i]["FN"] + " " +data[i]["LN"] + " " + data[i]["Email"] + " " + data[i]["Role"])
	htmldata += '''
		</table>
		</body>
		</html>
	'''


def aftifactory = Artifactory.newServer 'Artifactory'

pipeline{
	agent any

	stages {
		stage("Build"){
			steps{
				withMaven(mavenSettingsFilePath:'tools/maven/settings.xml'){
					sh 'mvn clean install'
				}
			}
		}

		stage("Artifacts"){
			steps{
				archiveArtifacts artifacts:"lib/*"
				sh "zip -r rel.zip"
				script{
					articactory.upload({"files":[{"pattern":"rel.zip"}, "target":"{release}/rel.zip"]})
				}
			}
		}

		post{
			always{
				cleanws()
			}
		}

		options{
			buildDiscarder(logRotator(numToKeepStr:"10"))
		}

	}
}




####### GIT #########

git clone "https://companyurl/project.git"
cd project
git add settings.xml
git commit -m "feat(): COSOSCHC-1233 - updated settings file"
git push origin develop






























