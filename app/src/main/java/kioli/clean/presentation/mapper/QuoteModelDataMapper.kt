package kioli.clean.presentation.mapper

import kioli.clean.data.entity.Quote
import kioli.clean.presentation.model.QuoteModel
import java.util.*

/**
 * Mapper class used to transform [Quote] (in the data layer) to
 * [QuoteModel] in the presentation layer
 */
class QuoteModelDataMapper {

    /**
     * Transform a [Quote] into an [QuoteModel]
     *
     * @param quote Object to be transformed
     *
     * @return [QuoteModel]
     */
    fun transform(quote: Quote?): QuoteModel {
        if (quote == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
        return QuoteModel(quote.text)
    }

    /**
     * Transform a Collection of [Quote] into a Collection of [QuoteModel]
     *
     * @param usersCollection Objects to be transformed
     *
     * @return List of [QuoteModel]
     */
    fun transform(usersCollection: Collection<Quote>?): Collection<QuoteModel> {
        return if (usersCollection != null && !usersCollection.isEmpty()) {
            usersCollection.mapTo(ArrayList()) { transform(it) }
        } else {
            emptyList()
        }
    }
}
