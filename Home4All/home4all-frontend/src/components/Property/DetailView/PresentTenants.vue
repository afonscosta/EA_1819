<template>
  <b-card
    v-if="type === 'bedrooms'"
    border-variant="secondary"
    header="Arrendatários atuais"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col>
        <label>Feminino: {{ shared.females }}</label>
      </b-col>
      <b-col>
        <label>Masculino: {{ shared.males }}</label>
      </b-col>
      <b-col>
        <label>Fumadores: {{ shared.smokers }}</label>
      </b-col>
      <b-col>
        <label>Animais de estimação: {{ shared.pets }}</label>
      </b-col>
    </b-row>
    <b-form-group id="present-tenants-ocupation-form-group" label="Ocupações dos arrendatários atuais:">
      <b-form-checkbox-group
        disable
        v-model="shared.ocupation"
        :options="optionsOcupation"
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
    shared: {
      required: true,
      type: Object
    }
  },
  data: () => ({
    optionsOcupation: [
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
