package kioli.clean.domain.interactor

import io.reactivex.Observable
import kioli.clean.data.entity.Quote
import kioli.clean.domain.executor.ThreadExecution
import kioli.clean.domain.executor.ThreadPostExecution
import kioli.clean.domain.repository.QuoteRepositoryI

/**
 * Implementation of [UseCase] that represents a use case for retrieving some getQuote
 */
internal class QuoteUseCase constructor(private val quoteRepository: QuoteRepositoryI,
                                        threadOfExecution: ThreadExecution,
                                        threadOfPostExecution: ThreadPostExecution)
    : UseCase<Quote, Boolean>(threadOfExecution, threadOfPostExecution) {

    override fun buildUseCaseObservable(params: Boolean?): Observable<Quote> {
        params?.let {
            return quoteRepository.getQuote(it)
        }
        return quoteRepository.getQuote(false)
    }
}
