<template>
  <b-card
    border-variant="secondary"
    header="Informação Geral"
    header-border-variant="secondary"
  >
    <p>Descrição: {{ description }}</p>
    <b-row>
      <b-col>
        <p>Imóvel: {{ type }}</p>
      </b-col>
      <b-col>
        <p>Imóvel: {{ type }}</p>
        <p>Tipologia: {{ typology }}</p>
      </b-col>
      <b-col>
        <p>Área: {{ area }}</p>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <p>Distrito: {{ district }}</p>
      </b-col>
      <b-col>
        <p>Cidade: {{ city }}</p>
      </b-col>
    </b-row>

    <p>Rua: {{ street }}</p>

    <b-form-checkbox
      id="checkbox-1"
      v-model="furnished"
      name="checkbox-1"
      class="pb-2"
      disable
    >Mobilado</b-form-checkbox>

    <b-row>
      <b-col>
        <p v-if="type !== 'bedrooms'">Disponível a partir de: {{ availability }}</p>
      </b-col>
      <b-col>
        <p v-if="type !== 'bedrooms'">Operação: {{ operation }}</p>
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <p v-if="type !== 'bedrooms'">Mensalidade: {{ rentPrice }}</p>
      </b-col>
      <b-col>
        <p v-if="type !== 'bedrooms'">Preço total: {{ sellPrice }}</p>
      </b-col>
    </b-row>
  </b-card>
</template>

<script>
export default {
  name: 'PropertyInfo',
  props: {
    description: {
      required: true,
      type: String
    },
    type: {
      required: true,
      type: String
    },
    typology: {
      required: true,
      type: String
    },
    area: {
      required: true,
      type: Number
    },
    district: {
      required: true,
      type: String
    },
    city: {
      required: true,
      type: String
    },
    street: {
      required: true,
      type: String
    },
    furnished: {
      required: true,
      type: Boolean
    },
    availability: {
      required: true,
      type: String
    },
    operation: {
      required: true,
      type: String
    },
    rentPrice: {
      required: true,
      type: Number
    },
    sellPrice: {
      required: true,
      type: Number
    }
  }
}
</script>
