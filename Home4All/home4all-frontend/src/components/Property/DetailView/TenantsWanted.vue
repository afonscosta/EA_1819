<template>
  <b-card
    border-variant="secondary"
    header="Tipos de inquilinos procurados"
    header-border-variant="secondary"
  >
    <b-row>
      <b-col cols="12" lg="4">
        <p><strong>Género:</strong> {{ parseGenders(allowedGenders) }}</p>
      </b-col>
      <b-col cols="12" lg="4">
        <p><strong>Idade mínima:</strong> {{
          allowedMinAge ? allowedMinAge : 'não existe limite'
        }}</p>
      </b-col>
      <b-col cols="12" lg="4">
        <p><strong>Idade máxima:</strong> {{
          allowedMaxAge ? allowedMaxAge : 'não existe limite'
        }}</p>
      </b-col>
    </b-row>
    <b-form-group align="left" id="tenants-wanted-ocupation-form-group" label="Ocupação:">
      <b-form-checkbox-group
        id="checkbox-group-1"
        v-model="allowedOccupations"
        :options="optionsOccupation"
        buttons
        button-variant="secondary"
        disabled
      ></b-form-checkbox-group>
    </b-form-group>
    <b-row align-h="center">
      <b-col cols="12" lg="3">
        <b-form-checkbox
          class="checkbox-spacing"
          id="checkbox-2"
          v-model="allowedSmokers"
          name="checkbox-2"
          disabled
        >Permitir fumadores</b-form-checkbox>
      </b-col>
      <b-col cols="12" lg="3">
        <b-form-checkbox
          class="checkbox-spacing"
          id="checkbox-3"
          v-model="allowedPets"
          name="checkbox-3"
          disabled
        >Permitir animais de estimação</b-form-checkbox>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'TenantsWanted',
  props: {
    allowedGenders: {
      type: String
    },
    allowedMinAge: {
      type: Number
    },
    allowedMaxAge: {
      type: Number
    },
    allowedOccupations: {
      type: Array
    },
    allowedSmokers: {
      type: Boolean
    },
    allowedPets: {
      type: Boolean
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
  }),
  methods: {
    parseGenders (gender) {
      if (gender === 'undefined') {
        return 'Não definido'
      } else if (gender === 'male') {
        return 'Masculino'
      } else if (gender === 'female') {
        return 'Feminino'
      }
    }
  }
}
</script>

<style scope>
#tenants-wanted-ocupation-form-group {
  margin-bottom: 1rem !important;
}

.btn-secondary {
  background-color: rgba(220,53,69, 0.7) !important;
}

.btn-secondary:not(:disabled):not(.disabled):active,
.btn-secondary:not(:disabled):not(.disabled).active,
.show > .btn-secondary.dropdown-toggle {
  background-color: rgba(0,128,0,0.7) !important;
  border-color: rgba(0,128,0,0.7) !important;
  box-shadow: 0 0 0 0.2rem rgba(72, 180, 97, 0.5) !important;
}

.btn-group {
  display: flex !important;
  flex-wrap: wrap;
}

.btn-group > .btn.active {
  background-color: rgba(0,128,0,0.7) !important;
  border-color: rgba(0,128,0,0.7) !important;
  box-shadow: 0 0 0 0.2rem rgba(72, 180, 97, 0.5) !important;
}

.btn-group > .btn,
.btn-group > .btn-group > .btn {
  margin: 0.375rem 0.75rem;
  border-radius: 0.25rem !important;
}

.checkbox-spacing {
  margin-top: 0.5rem;
}
</style>
