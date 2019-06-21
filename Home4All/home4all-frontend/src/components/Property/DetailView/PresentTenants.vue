<template>
  <b-card
    v-if="type === 'bedrooms'"
    border-variant="secondary"
    header="Arrendatários atuais"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col>
        <label>Feminino: {{ females }}</label>
      </b-col>
      <b-col>
        <label>Masculino: {{ males }}</label>
      </b-col>
      <b-col>
        <label>Fumadores: {{ smokers }}</label>
      </b-col>
      <b-col>
        <label>Nº de animais de estimação: {{ petsQuantity }}</label>
      </b-col>
      <b-col>
        <label>Tipos de animais de estimação: {{ pets }}</label>
      </b-col>
    </b-row>
    <b-form-group id="present-tenants-ocupation-form-group" label="Ocupações dos arrendatários atuais:">
      <b-form-checkbox-group
        disabled
        v-model="occupations"
        :options="optionsOccupation"
        buttons
        button-variant="secondary"
      ></b-form-checkbox-group>
    </b-form-group>
  </b-card>
</template>

<script>
export default {
  name: 'PresentTenants',
  props: {
    type: {
      type: String
    },
    females: {
      type: Number
    },
    males: {
      type: Number
    },
    occupations: {
      type: Array
    },
    pets: {
      type: Array
    },
    petsQuantity: {
      type: Number
    },
    smokers: {
      type: Number
    }
  },
  data: () => ({
    optionsOccupation: [
      { value: 'student', text: 'Estudante' },
      { value: 'studentWorker', text: 'Trabalhador-estudante' },
      { value: 'worker', text: 'Trabalhador' },
      { value: 'retired', text: 'Reformado' },
      { value: 'unemployed', text: 'Desempregado' }
    ]
  })
}
</script>

<style scope>
#present-tenants-ocupation-form-group {
  margin: 0px !important;
}

#present-tenants-form-group {
  margin: 0px !important;
}
</style>
