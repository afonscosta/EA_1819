<template>
  <b-container>
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
              type="email"
              required
              placeholder="Insera email"
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-2" label="Nome:" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model="form.name"
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
              type="password"
              required
              placeholder="Insira a password"
            ></b-form-input>
          </b-form-group>

          <b-form-group id="input-group-4" label="Idade:" label-for="input-4">
            <b-form-input
              id="input-4"
              v-model="form.age"
              type="number"
              required
              placeholder="Insira a idade"
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
              required
              placeholder="Selecione a sua data de nascimento"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-7"
            label="Género:"
            label-for="input-7"
          >
            <b-form-select v-model="form.gender" required :options="gender_options"></b-form-select>
          </b-form-group>

          <b-form-group
            id="input-group-8"
            label="Ocupação:"
            label-for="input-8"
          >
            <b-form-select v-model="form.ocupation" required :options="ocupation_options"></b-form-select>
          </b-form-group>

          <b-button type="submit" variant="primary">Submit</b-button>
          <b-button type="reset" variant="danger">Reset</b-button>
          <b-button v-if="selected.length > 0" @click="deleteU" variant="danger"
            >Delete</b-button
          >
        </b-form>
      </b-col>
      <b-col md="6">
        <b-table
          selectable
          select-mode="single"
          selectedVariant="success"
          :items="users"
          @row-selected="rowSelected"
        ></b-table>
      </b-col>
    </b-row>
    <b-row class="justify-content-md-center">
      <b-col md="6">
        <b-card class="mt-3" header="Form Data Result">
          <pre class="m-0">{{ form }}</pre>
        </b-card>
      </b-col>
      <b-col md="6">
        <b-card class="mt-3" header="Get users result">
          <pre class="m-0">{{ users }}</pre>
        </b-card>
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
      age: null,
      phone: '',
      birthday: '',
      gender: '',
      ocupation: ''
    },
    selected: [],
    gender_options: [
      { value: null, text: 'Selecione o seu género' },
      { value: 'male', text: 'Masculino' },
      { value: 'female', text: 'Feminino' }
    ],
    ocupation_options: [
      { value: null, text: 'Selecione a sua ocupação' },
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  }),
  created () {
    this.getUsers()
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
      this.addUser(this.form)
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
