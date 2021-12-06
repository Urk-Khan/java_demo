git config --global user.name/email 	; to configure user name or mail
git config --list
Urk-Khan	urk003khan007

git status		; To check stage status
git init		; To create repository(.git folder) 
git add --a / git add  -A / git add 'fileName.extention' ; to tracked files
git comit -m "comint"	; To Commit files
git log			; to check commit code
rm -rf .git		; To remove repository(.git folder)
git clone 'link' 'new folder name; optional' 		; to clone repository
.gitignore => *.log	; to ignore error.
git diff		; to compare
git diff -- staged
git comit -a -m	"comint"; To Commit files

=>git Hub<=
git remote add 'name(origin)' 'link' //git remote add origin https://github.com/Urk-Khan/java_demo.git

=>ssh Key<=
ssh-keygen -t rsa -b 4096 -C "ur.khan@outlook.com"
eval "$(ssh-agent -s)"
ssh-add ~/.ssh/id_rsa
tail ~/.ssh/id_rsa.pub
