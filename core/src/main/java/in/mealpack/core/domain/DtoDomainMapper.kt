package `in`.mealpack.core.domain

interface DtoDomainMapper <T,DomainModel>{
    fun mapFromNetworkToDomain(networkDto:T):DomainModel
    fun mapFromDomainToNetwork(domain:DomainModel):T
}