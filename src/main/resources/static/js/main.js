
Vue.component('students-list', {
    data() {
        return {
            students: [],
            name: "",
            surname: "",
            course: ""
        }
    },
    template:
        '<div>' +
            '<h3>Add user</h3>\n' +
            '<label for="name"><b>Name</b></label>\n' +
            '<input type="text" placeholder="Enter Name" v-model="name" name="name" id="name" required>\n' +
            '<label for="surname"><b>Surname</b></label>\n' +
            '<input type="text" placeholder="Enter Surname" v-model="surname" name="surname" id="surname" required>\n' +
            '<label for="course"><b>Group</b></label>\n' +
            '<input type="text" placeholder="Enter Group" v-model="course" name="course" id="course" required>\n' +
            '<button @click="add_user">Add User</button>\n' +
            '<table>\n' +
                '<tr>\n' +
                    '<th>ID</th>\n' +
                    '<th>NAME</th>\n' +
                    '<th>SURNAME</th>\n' +
                    '<th>GROUP</th>\n' +
                    '<th>ACTIONS</th>\n' +
                '</tr>\n' +
                '<student-row @update="update" v-for="student in students" :key="student.id" :student="student" /> ' +
            '</table>\n' +
        '</div>',
    created: function () {
        this.update()
    },
    methods: {
        update() {
            axios.get('/students/')
                .then((response) => {
                    this.students = response.data;
                    console.log(response);
                });
        },

        add_user() {
            axios.post('/students/', {
                "name": this.name,
                "surname": this.surname,
                "course": this.course
            }).then(() => {
                this.update()
            });
        }
    }
});

Vue.component('student-row', {
    events: ['update'],
    props: ['student'],
    template:
        '<tr>\n' +
        '<td>{{ student.id }}</td>\n' +
        '<td>{{ student.name }}</td>\n' +
        '<td>{{ student.surname }}</td>\n' +
        '<td>{{ student.course }}</td>\n' +
        '<td><button @click="remove">delete</button></td>\n' +
        '</tr>\n',
    methods: {
        remove() {
            axios.delete('/students/' + this.student.id).then(() => {
                this.$emit("update")
            });
        }
    }
});

var app = new Vue({
    el: '#app',
    data: {
        is_logged: false,
        is_warning: false,
        log_username: "admin",
        log_password: "pass",
        username: "",
        password: "",
        students: []
    },
    template:
        '<div class="main">\n' +
        '   <div v-if="!is_logged">\n' +
        '       <div>\n' +
        '       <label for="username"><b>Username</b></label>\n' +
        '       <input type="text" placeholder="Enter Username" v-model="username" name="username" required>\n' +
        '       <label for="password"><b>Password</b></label>\n' +
        '       <input type="password" placeholder="Enter Password" v-model="password" name="password" required>\n' +
        '       <button @click="login">Login</button>\n' +
        '       </div>\n' +
        '   </div>\n' +
        '   <div v-else>\n' +
        '       <students-list :students="students"/>\n' +
        '   </div>\n' +
        '</div>\n',
    methods: {
        login() {
            if(this.username === this.log_username && this.password === this.log_password) {
                this.is_logged = true;
            } else {
                console.log("pnh");
            }
        }
    }
})