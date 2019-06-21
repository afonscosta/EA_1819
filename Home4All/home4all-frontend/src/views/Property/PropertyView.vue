<template>
  <div>
    <h3 class="title">{{ property.name }}</h3>
    <b-button @click="$router.push({ name: 'propertyEdit' })" variant="danger">Editar</b-button>
    <b-container>
      <b-row class="justify-content-md-center">
        <b-col>
          <label>Nome: {{ property.name }}</label>
          <b-card-group deck class="deck-images-prop-info">
            <Images :images="property.images" class="images"/>
            <PropertyInfo
              :description="property.description"
              :type="property.type"
              :typology="property.typology"
              :area="property.area"
              :district="property.district"
              :city="property.city"
              :address="property.address"
              :lat="property.lat"
              :lng="property.lng"
              :furnished="property.furnished"
              :totalAccess="property.totalAccess"
              :availability="property.availability"
              :rent="property.rent"
              :sell="property.sell"
              :rentPrice="property.rentPrice"
              :sellPrice="property.sellPrice"/>
          </b-card-group>

          <Bedroom
            :type="property.type"
            :bedrooms="property.bedrooms"/>

          <PresentTenants
            :type="property.type"
            :females="property.females"
            :males="property.males"
            :occupations="property.occupations"
            :pets="property.pets"
            :petsQuantity="property.petsQuantity"
            :smokers="property.smokers"
            class="present-tenants"/>

          <b-card-group deck>
            <RentInclude :rentInc="property.expensesIncluded"/>
            <DivEquipInclude :divEquipInc="property.equipmentIncluded"/>
          </b-card-group>

          <TenantsWanted
            class="tenants-wanted"
            :allowedGenders="property.allowedGenders"
            :allowedMinAge="property.allowedMinAge"
            :allowedMaxAge="property.allowedMaxAge"
            :allowedOccupations="property.allowedOccupations"
            :allowedSmokers="property.allowedSmokers"
            :allowedPets="property.allowedPets"/>
          <b-button @click="$router.push({ name: 'propertyEdit' })" variant="danger">Editar</b-button>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import { mapState } from 'vuex'
import Bedroom from '@/components/Property/DetailView/Bedroom'
import DivEquipInclude from '@/components/Property/DetailView/DivEquipInclude'
import Images from '@/components/Property/DetailView/Images'
import PresentTenants from '@/components/Property/DetailView/PresentTenants'
import PropertyInfo from '@/components/Property/DetailView/PropertyInfo'
import RentInclude from '@/components/Property/DetailView/RentInclude'
import TenantsWanted from '@/components/Property/DetailView/TenantsWanted'

export default {
  name: 'property',
  components: {
    Bedroom,
    DivEquipInclude,
    Images,
    PresentTenants,
    PropertyInfo,
    RentInclude,
    TenantsWanted
  },
  data: () => ({
  }),
  computed: {
    ...mapState({
      property: state => state.properties.property
    })
  },
  methods: {
  }
}
</script>
