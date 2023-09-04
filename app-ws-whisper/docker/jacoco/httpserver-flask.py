import subprocess
from subprocess import Popen, PIPE
from subprocess import check_output
from flask import Flask


def get_shell_script_output_using_communicate():
   #fp = os.path.join('python', 'jacococli-dump.sh')
    session = Popen(['./jacococli-dump.sh'], stdout=PIPE, stderr=PIPE)
    stdout, stderr = session.communicate()
    if stderr:
        raise Exception("Error "+str(stderr))
    return stdout.decode('utf-8')

def get_shell_script_output_using_check_output():
    stdout = check_output(['./jacococli-dump.sh']).decode('utf-8')
    return stdout

app = Flask(__name__)

@app.route('/',methods=['GET',])
def home():
    return get_shell_script_output_using_communicate()

app.run(host='0.0.0.0',port=5000, debug=True)