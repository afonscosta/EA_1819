<template>
  <b-container>
    <b-row class="justify-content-md-center">
      <b-col md="6">
        <b-form @submit="onSubmit">

          <b-form-group id="input-group-2" label="Nome:" label-for="input-2">
            <b-form-input
              id="input-2"
              v-model="form.name"
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
              type="date"
              placeholder="Selecione a sua data de nascimento"
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="input-group-7"
            label="Género:"
            label-for="input-7"
          >
            <b-form-select v-model="form.gender" :options="gender_options"></b-form-select>
          </b-form-group>

          <b-form-group
            id="input-group-8"
            label="Ocupação:"
            label-for="input-8"
          >
            <b-form-select v-model="form.ocupation" :options="ocupation_options"></b-form-select>
          </b-form-group>

          <b-button type="submit" variant="primary">Guardar</b-button>

        </b-form>
      </b-col>
      <!-- <b-col md="6">
        <b-table
          selectable
          select-mode="single"
          selectedVariant="success"
          :items="users"
          @row-selected="rowSelected"
        ></b-table>
      </b-col> -->
    </b-row>
    <!-- <b-row class="justify-content-md-center">
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
    </b-row> -->

    <b-button v-on:click="showInfoVendas = !showInfoVendas" variant="primary">Mais informação</b-button>

    <div v-if="showInfoVendas" class="vendasinfo">
      <hr>
      <b-row class="justify-content-md-center">
        <b-form-group
                id="input-group-6"
                label="A partir de:"
                label-for="input-6"
              >
                <b-form-input
                  id="input-6"
                  v-model="eventsFrom"
                  type="date"
                  placeholder="Selecione uma data"
                ></b-form-input>
        </b-form-group>

        <b-form-group
                id="input-group-6"
                label="Até:"
                label-for="input-6"
              >
                <b-form-input
                  id="input-6"
                  v-model="eventsTo"
                  type="date"
                  placeholder="Selecione uma data"
                ></b-form-input>
        </b-form-group>

        <b-button v-on:click="getStatisticsInfo({dateBegin: eventsFrom, dateEnd: eventsTo})" type="submit" variant="primary">Procurar</b-button>
      </b-row>

      <GChart
        v-if="chartData[0].length > 1"
        type="ColumnChart"
        :data="chartData[0]"
        :options="chartOptions"
      />

      <GChart
        v-if="chartData[1].length > 1"
        type="ColumnChart"
        :data="chartData[1]"
        :options="chartOptions"
      />
    </div>
  </b-container>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import { GChart } from 'vue-google-charts'

export default {
  name: 'userInfo',
  data: () => ({
    showInfoVendas: false,
    eventsTo: '',
    eventsFrom: '',
    // chartData: [['Data', 'Vendas']],
    // chartData: [
    //     ['Data', 'Vendas'],
    //     ['2/3/2014', 1000],
    //     ['2015', 1170],
    //     ['2016', 660],
    //     ['2017', 1030]
    //   ],
    chartOptions: {
      title: 'Company Performance'
    },
    form: {
      name: '',
      password: '',
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
    this.getUser()
    this.eventsFrom = this.getDateBegin()
    this.eventsTo = this.getDateEnd()
    this.getStatisticsInfo({
      dateBegin: this.eventsFrom,
      dateEnd: this.eventsTo
    })
    console.log(this.$store.state.statistics)
    this.form.name = this.$store.state.login.user.name
    if (this.$store.state.login.user.phone) {
      this.form.phone = this.$store.state.login.user.phone
    }
    this.form.birthday = this.$store.state.login.user.birthday
    this.form.gender = this.$store.state.login.user.gender
    console.log(this.$store.state.login.user.occupation)
    this.form.ocupation = this.$store.state.login.user.occupation
  },
  computed: {
    ...mapState({
      statistics: state => state.statistics.statistics
    }),
    chartData () {
      let res = [[], []]
      if (Object.keys(this.statistics).length > 0) {
        console.log(this.statistics)
        res = [[['Data', 'Vendas']], [['Data', 'Anunciados', 'Vendidos/Alugados']]]
        let keys = Object.keys(this.statistics.g1)
        let i
        for (i = 0; i < keys.length; i++) {
          res[0].push([keys[i], this.statistics.g1[keys[i]]])
        }
        keys = Object.keys(this.statistics.g2)
        for (i = 0; i < keys.length; i++) {
          res[1].push([
            keys[i],
            this.statistics.g2[keys[i]].key,
            this.statistics.g2[keys[i]].value
          ])
        }
      }
      console.log('result', res)
      return res
    }
  },
  methods: {
    ...mapActions('users', ['addUser', 'updateUser', 'deleteUser']),
    ...mapActions('login', ['getUser']),
    ...mapActions('statistics', ['getStatisticsInfo']),
    // parseGraphData () {
    //   console.log('PARSE GRAPH')
    //   console.log(this.statistics)
    //   // let keys = Object.keys(this.$store.state.statistics.statistics)
    //   // for (var i = 0; i < keys.length; i++) {
    //   //   console.log(keys[i])
    //   //   console.log(this.$store.state.statistics.statistics.g1[keys[i]])
    //   //   // this.chartData.push([key, this.$store.state.statisticsstatistics.g1[key]])
    //   // }

    //   // console.log('CHART DATA')
    //   // console.log(this.chartData)
    // },
    getDateEnd () {
      const toTwoDigits = num => num < 10 ? '0' + num : num
      let today = new Date()
      let year = today.getFullYear()
      let month = toTwoDigits(today.getMonth())
      let day = toTwoDigits(today.getDate())
      return `${year}-${month}-${day}`
    },
    getDateBegin () {
      const toTwoDigits = num => num < 10 ? '0' + num : num
      let today = new Date()
      let year = today.getFullYear()
      today.setMonth(today.getMonth() - 1)
      let month = toTwoDigits(today.getMonth())
      let day = toTwoDigits(today.getDate())
      return `${year}-${month}-${day}`
    },
    onSubmit (evt) {
      evt.preventDefault()
      console.log(this.form)

      if (this.form.password !== '') {
        this.updateUser(this.form)
      } else {
        this.updateUser({
          name: this.form.name,
          phone: this.form.phone,
          birthday: this.form.birthday,
          gender: this.form.gender,
          ocupation: this.form.occupation
        })
      }
    }
  },
  components: {
    GChart
  }
}
</script>
