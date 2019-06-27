<template>
  <b-card
    v-if="type === 'bedrooms'"
    border-variant="secondary"
    header="Arrendatários atuais"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col cols="6" lg="4">
        <label><strong>Feminino:</strong> {{ females }}</label>
      </b-col>
      <b-col cols="6" lg="4">
        <label><strong>Masculino:</strong> {{ males }}</label>
      </b-col>
      <b-col cols="12" lg="4">
        <label><strong>Fumadores:</strong> {{ smokers }}</label>
      </b-col>
      <b-col cols="12" lg="6">
        <label><strong>Nº de animais de estimação:</strong> {{ petsQuantity }}</label>
      </b-col>
      <b-col cols="12" lg="6">
        <label><strong>Tipos de animais de estimação:</strong> {{ pets.toString() }}</label>
      </b-col>
    </b-row>
    <b-form-group align="left" id="present-tenants-ocupation-form-group" label="Ocupações dos arrendatários atuais:">
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
