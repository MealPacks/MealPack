package `in`.mealpack.core

interface DtoDomainMapper <DtoModel,DomainModel>{
    fun mapFromNetworkToDomain(networkDto:DtoModel):DomainModel
    fun mapFromDomainToNetwork(domain:DomainModel):DtoModel
}