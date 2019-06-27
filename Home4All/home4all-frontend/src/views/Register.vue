<template>
  <b-container class="container-div">
    <b-row class="justify-content-md-center">
      <b-col md="6">
        <b-form @submit="onSubmit" @reset="onReset">
          <b-form-group
            id="input-group-1"
            label="Endereço de email:"
            label-for="input-1"
          >
            <b-form-input
              id="input-1"
              v-model="form.email"
              class="input"
              type="email"
              required
              placeholder="Insera email"
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-2" label="Nome:" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model="form.name"
              class="input"
              required
              placeholder="Insira o nome"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-3"
            label="Password:"
            label-for="input-3"
          >
            <b-form-input
              id="input-3"
              v-model="form.password"
              class="input"
              type="password"
              required
              placeholder="Insira a password"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-5"
            label="Telefone/Telemóvel:"
            label-for="input-5"
          >
            <b-form-input
              id="input-5"
              v-model="form.phone"
              class="input"
              type="number"
              placeholder="Insira o seu número"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-6"
            label="Data de nascimento:"
            label-for="input-6"
          >
            <b-form-input
              id="input-6"
              v-model="form.birthday"
              class="input"
              type="date"
              required
              placeholder="Selecione a sua data de nascimento"
            ></b-form-input>
          </b-form-group>

          <b-row>
            <b-col>
              <b-form-group
                id="input-group-7"
                label="Género:"
                label-for="input-7"
              >
                <b-form-select 
                  v-model="form.gender"
                  class="input"
                  required 
                  :options="gender_options"
                ></b-form-select>
              </b-form-group>
            </b-col>
            <b-col>
              <b-form-group
                id="input-group-8"
                label="Ocupação:"
                label-for="input-8"
              >
                <b-form-select 
                  v-model="form.occupation"
                  class="input"
                  required 
                  :options="occupation_options"
                ></b-form-select>
              </b-form-group>
            </b-col>
          </b-row>

          <b-button-group>
            <b-button class="button" type="submit" variant="primary">Registar</b-button>
            <b-button class="button-reset" type="reset">Limpar</b-button>
          </b-button-group>
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'

export default {
  name: 'register',
  data: () => ({
    form: {
      id: null,
      email: '',
      name: '',
      password: '',
      phone: '',
      birthday: '',
      gender: '',
      occupation: ''
    },
    selected: [],
    gender_options: [
      { value: null, text: 'Selecione o seu género' },
      { value: 'male', text: 'Masculino' },
      { value: 'female', text: 'Feminino' }
    ],
    occupation_options: [
      { value: null, text: 'Selecione a sua ocupação' },
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  created () {
    // this.getUsers()
  },
  computed: {
    ...mapState({
      users: state => state.users.users
    })
  },
  methods: {
    ...mapActions('users', ['getUsers', 'addUser', 'updateUser', 'deleteUser']),
    onSubmit (evt) {
      evt.preventDefault()
      console.log(this.form.birthday)
      console.log(this.form)
      this.addUser(this.form).then(() => {
        this.$router.push('/login')
      })
    },
    onReset (evt) {
      evt.preventDefault()
      // Reset our form values
      this.form.id = null
      this.form.email = ''
      this.form.name = ''
      this.form.password = ''
      this.form.age = null
      this.form.phone = ''
    },
    rowSelected (users) {
      console.log(users)
      this.selected = users
      if (users.length > 0) {
        this.form.id = users[0].id
        this.form.email = users[0].email
        this.form.name = users[0].name
        this.form.password = 'password'
        this.form.age = users[0].age
        this.form.phone = users[0].phone
      }
    },
    deleteU () {
      this.deleteUser(this.form.id)
    }
  }
}
</script>

<style scoped>

.container-div {
  margin-top: 1rem;
}

.button {
  background-color: rgb(241, 146, 2);
  border: none;
  color: rgb(44, 44, 44) ;
}

.button-reset {
  color: rgb(44, 44, 44) ;
  border: none;
}

.input {
  border: 2px solid rgb(197, 197, 197);
  font-size: 12pt;
}

</style>
