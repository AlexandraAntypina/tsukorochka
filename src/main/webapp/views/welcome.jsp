<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<cfx-page-section id="cfx-main-sugaring-intro">

				<cfx-paralax-bgnd --image="url('../media/try-9.jpg">
					<cfx-section class="text-center h-center">
						<img src="<c:url value="media/title-icon-alt.png" />">
						<div class="text-700 base-color text-thin-border-white">Професійний догляд за шкірою</div>
						<div class="text-900 base-color text-thin-border-white">Шугарінг</div>
						<cfx-v-spacer-large></cfx-v-spacer-large>
						<a class="a-button text-500" type="invers" href="#about-sugaring">Детальніше</a>
					</cfx-section>
				</cfx-paralax-bgnd>

				<cfx-flex item-spacing="middle" item-border="int" class="font-base bg-color text-center alt-color">
						<cfx-flex-item>
							<div class="text-700">750+</div>
							<cfx-v-spacer-small></cfx-v-spacer-small>
							<div class="cfx text-700" @font-size="24px">Trunsting clients</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700">39</div>
							<cfx-v-spacer-small></cfx-v-spacer-small>
							<div class="cfx text-700" @font-size="24px">Types of massage</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700">98%</div>
							<cfx-v-spacer-small></cfx-v-spacer-small>
							<div class="cfx text-700" @font-size="24px">Retunring Clients</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700">16</div>
							<cfx-v-spacer-small></cfx-v-spacer-small>
							<div class="cfx text-700" @font-size="24px">Awards won</div>
						</cfx-flex-item>
				</cfx-flex>

				<cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>

				<div class="text-center">
					<img src="media/title-icon-alt.png" alt="">
					<cfx-v-spacer-small></cfx-v-spacer-small>
					<div class="text-700 h-center">The Great Place for Relax & Heal</div>
					<cfx-v-spacer-small></cfx-v-spacer-small>
					<div class="cfx text-400 h-center text-topic" @font-size="14px" @width="50vw">
						Aromatherapy massage is an innocuous therapeutic massage that employs essential oils extracted from fruits, leaves, woods, resins, stems, and flowers of plants and trees in a way that can improve physical, emotional, and mental health. These essential oils can be used individually or blended with other oils to create different “recipes” & massaged into the body for different effects.
					</div>
				</div>


		   </cfx-page-section>

		   <cfx-v-spacer-middle></cfx-v-spacer-middle>
		   <cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>

		   <cfx-page-section id="why-to-chose-us">
				<cfx-paralax-bgnd --image="url('../media/mt-1085-home-bg2.jpg')">
					<cfx-section class="text-center h-center alt-color">

						<img src="media/title-icon-base.png" alt="">
						<div class="text-700">Як проходить процес шугарингу?</div>

						<cfx-flex type="flex-row" @padding-left="15px" @padding-right="15px">
							<cfx-flex-item>
								<img src="media/briliant.png" alt="">
								<div class="text-400">ПІДГОТОВКА</div>
								<div>
									Шкіра депільованої зони обробляється професійним очищуючим засобом, який також обезжирює та дезинфікує шкіру.
								</div>
							</cfx-flex-item>
							<cfx-flex-item>
								<img src="media/leaf.png" alt="">
								<div class="text-400">ДЕПІЛЯЦІЯ</div>
								<div>
								Оброблення шкіри тальком. Безпосереднє видалення небажаного волосся мануальною технікою.
								</div>
							</cfx-flex-item>
							<cfx-flex-item>
								<img src="media/sun.png" alt="">
								<div class="text-400">ЗВОЛОЖЕННЯ</div>
								<div>
								Зняття залишків пасти, обробка шкіри засобом після депіляції, який зволожує, заспокоює та знімає подразнення шкіри.
								</div>
							</cfx-flex-item>
							
						</cfx-flex>
					</cfx-section>
			   </cfx-paralax-bgnd>

			   <cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>

				<div class="text-center">
					<img src="media/title-icon-alt.png" alt="">
					<cfx-v-spacer-small></cfx-v-spacer-small>
					
					<div class="text-700 h-center">аіваіві</div>
					<cfx-v-spacer-small></cfx-v-spacer-small>
			   </div>

				<cfx-flex type="flex" item-spacing="small" class="cfx h-center text-left font-curs" @max-width="80vw">
					<cfx-flex-row>
						<cfx-flex-item>
							<div class="text-700 base-color">01.</div>
							<a class="font-base text-400 link" href="#">Relaxation Massage</a>
							<div class="font-simple text-400 text-topic">
								Our full body massage offers the most complete, all around stimulating massage possible by targeting all major massage areas on the body to promote a balanced state of relaxation!
							</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700 base-color">02.</div>
							<a class="font-base text-400 link" href="#">Deep Tissue Massage</a>
							<div class="font-simple text-400 text-topic" >
								Our full body massage offers the most complete, all around stimulating massage possible by targeting all major massage areas on the body to promote a balanced state of relaxation!
							</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700 base-color">03.</div>
							<a class="font-base text-400 link" href="#">Neck and Shoulder Massage</a>
							<div class="font-simple text-400 text-topic">
								Our full body massage offers the most complete, all around stimulating massage possible by targeting all major massage areas on the body to promote a balanced state of relaxation!
							</div>
						</cfx-flex-item>
					</cfx-flex-row>
					<cfx-flex-row>
						<cfx-flex-item>
							<div class="text-700 base-color">04.</div>
							<a class="font-base text-400 link" href="#">Head Massage</a>
							<div class="font-simple text-400 text-topic">
								Our full body massage offers the most complete, all around stimulating massage possible by targeting all major massage areas on the body to promote a balanced state of relaxation!
							</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700 base-color">05.</div>
							<a class="font-base text-400 link" href="#">Sports Massage</a>
							<div class="font-simple text-400 text-topic">
								Our full body massage offers the most complete, all around stimulating massage possible by targeting all major massage areas on the body to promote a balanced state of relaxation!
							</div>
						</cfx-flex-item>
						<cfx-flex-item>
							<div class="text-700 base-color">06.</div>
							<a class="font-base text-400 link" href="#">Thai Massage</a>
							<div class="font-simple text-400 text-topic">
								Our full body massage offers the most complete, all around stimulating massage possible by targeting all major massage areas on the body to promote a balanced state of relaxation!
							</div>
						</cfx-flex-item>
					</cfx-flex-row>
				</cfx-flex>
		   </cfx-page-section>

		   <cfx-v-spacer-middle></cfx-v-spacer-middle>
		   <cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>

		   <cfx-page-section id="sign-up">

				<cfx-paralax-bgnd --image="url('../media/mt-1085-home-bg3.jpg')">
					<cfx-section class="text-center h-center alt-color font-curs">
						<img src="media/title-icon-base.png" alt="">
						<div class="text-700">Sign Up for Your</div>
						<div class="text-700">FREE 1st Natural Brazilian Waxing</div>
						<cfx-v-spacer-large></cfx-v-spacer-large>
						<a class="cfx a-button text-500" type="light" href="" @font-size="24px">Book an apointment</a>
					</cfx-section>
				</cfx-paralax-bgnd>

				<cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>
				<div class="text-center">
					<img src="media/title-icon-alt.png" alt="">
					<cfx-v-spacer-small></cfx-v-spacer-small>
					<div class="text-700 font-curs h-center">See the Testimonials That Our Clients Have</div>
					<div class="text-700 font-curs h-center">Submitted So Far</div>
					<cfx-v-spacer-small></cfx-v-spacer-small>
				</div>

				<cfx-flex type="flex-row" item-spacing="small" class="h-center text-center font-curs" @max-width="70vw">
					<cfx-flex-item>
						<img src="media/section/mt-1085-home-img1.png" alt="">
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<div class="icon icon-quote-right h-center base-color text-700"></div>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<div class="font-simple text-topic">
							I just wanted to say thank you for the amazing massage ! I don’t think I have ever been to such a beautiful place to get a massage. It was nice, clean, relaxing, just a beautiful feel about it. Thank you very much and we have already booked our next appointment next month!
						</div>
						<cfx-v-spacer-large></cfx-v-spacer-large>
						<div class="font-base text-400" @font-size="22px">-  Leona Williams</div>
					</cfx-flex-item>
					<cfx-flex-item>
						<img src="media/section/mt-1085-home-img2.png" alt="">
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<div class="icon icon-quote-right h-center base-color text-700"></div>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<div class="font-simple text-topic">
							I just wanted to say thank you for the amazing massage ! I don’t think I have ever been to such a beautiful place to get a massage. It was nice, clean, relaxing, just a beautiful feel about it. Thank you very much and we have already booked our next appointment next month!
						</div>
						<cfx-v-spacer-large></cfx-v-spacer-large>
						<div class="font-base text-400" @font-size="22px">-  Tamara Smith</div>
					</cfx-flex-item>
					<cfx-flex-item>
						<img src="media/section/mt-1085-home-img3.png" alt="">
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<div class="icon icon-quote-right h-center base-color text-700"></div>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<div class="font-simple text-topic">
							I just wanted to say thank you for the amazing massage ! I don’t think I have ever been to such a beautiful place to get a massage. It was nice, clean, relaxing, just a beautiful feel about it. Thank you very much and we have already booked our next appointment next month!
						</div>
						<cfx-v-spacer-large></cfx-v-spacer-large>
						<div class="font-base text-400" @font-size="22px">-  Oliver Hamilton</div>
					</cfx-flex-item>
			   </cfx-flex>

				<cfx-section class="gray-bg text-center">
					<img src="media/title-icon-alt.png" alt="">
					<cfx-v-spacer-small></cfx-v-spacer-small>
					<div class="font-base text-700">Some Of Our Partners</div>
					<cfx-v-spacer-small></cfx-v-spacer-small>
					<ul class="ul-hlist h-center">
						<li><a class="link-inv" href=""><img src="media/section/mt-1085-home-partner1.png" alt=""></a></li>
						<li><a class="link-inv" href=""><img src="media/section/mt-1085-home-partner3.png" alt=""></a></li>
						<li><a class="link-inv" href=""><img src="media/section/mt-1085-home-partner4.png" alt=""></a></li>
						<li><a class="link-inv" href=""><img src="media/section/mt-1085-home-partner5.png" alt=""></a></li>
						<li><a class="link-inv" href=""><img src="media/section/mt-1085-home-partner6.png" alt=""></a></li>
<!--						<li><a class="link-inv" href=""><img src="media/section/mt-1085-home-partner7.png" alt=""></a></li>-->
					</ul>
				</cfx-section>
		   </cfx-page-section>

		   <cfx-page-section>
				<cfx-paralax-bgnd --image="url('../media/mt-1085-home-bg4.jpg')">
					<cfx-section class="text-center h-center alt-color font-curs">
						<cfx-flex type="flex-row" item-spacing="small" class="cfx h-center" @max-width="70vw">
							<cfx-flex-item>
									<img src="media/title-icon-alt.png" alt="">
									<div class="text-700">Why Get a Massage?</div>
									<div class="font-simple">
									Toxins in the body tend to accumulate in body tissue that receives little or no attention. Even active people who routinely workout fail to give needed attention to all parts of the body. Additionally, as people get older they typically become less active, leading to increased accumulation of toxins in the body. A professional, properly licensed aromatherapy massage specialist will work almost all areas and muscle tissues of the body, from head to toe…</div>
									<cfx-v-spacer-large></cfx-v-spacer-large>
									<a class="cfx a-button text-500" type="light" href="" @font-size="24px">Read more</a>
							</cfx-flex-item>
							<cfx-flex-item>
								<iframe class="video-frame v-center" src="https://www.youtube.com/embed/57QZlLwolbE" frameborder="0" allowfullscreen="" wmode="opaque" width="100%" height="120%"></iframe>
							</cfx-flex-item>
						</cfx-flex>
					</cfx-section>
				</cfx-paralax-bgnd>

				<cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>
				<div class="text-center">
					<img src="media/title-icon-alt.png" alt="">
					<cfx-v-spacer-small></cfx-v-spacer-small>
					<div class="text-700 font-curs h-center">Техника шугаринга</div>
					<cfx-v-spacer-small></cfx-v-spacer-small>
				</div>
				<cfx-v-spacer-extralarge></cfx-v-spacer-extralarge>

				<cfx-flex type="flex-row" item-spacing="small" class="cfx h-center text-center" @max-width="80vw">
					<cfx-flex-item>
						<a href=""><img src="media/section/mt-1085-home-img4.jpg" alt=""></a>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<a class="font-base text-400 link" href="" >
						Мануальна або класична техніка.
						<div class="font-simple text-400 text-topic">
							Видалення волосся проводиться мануально, тобто руками.
						</div>
						</a>
					</cfx-flex-item>
					<cfx-flex-item>
						<a href=""><img src="media/section/mt-1085-home-img5.jpg" alt=""></a>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<a href="" class="font-base text-400 link">
						Бандажна техніка.
							<div class="font-simple text-400 text-topic">
								 Використовується, якщо необхідно видалити велику кількість довгого волосся.
								 Ця техніка нагадує процес епіляції воском: паста наноситься шпателем, 
								 а потім поверх накладаються спеціальні смужки (бандаж), які знімають різким рухом
								 уздовж лінії росту волосся.
							 </div>
						</a>
					</cfx-flex-item>
					<cfx-flex-item>
						<a href=""><img src="media/section/mt-1085-home-img6.jpg" alt=""></a>
						<cfx-v-spacer-middle></cfx-v-spacer-middle>
						<a href="" class="font-base text-400 link">
						Шпательна техніка.
							<div class="font-simple text-400 text-topic"> 
								У цій техніці цукрової депіляції використовується шпатель, яким накладається і
								забирається паста. Дану техніку епіляції можна проводити на будь-якій зоні тіла.
							 </div>
						</a>
					</cfx-flex-item>

				</cfx-flex>
				<cfx-v-spacer-large></cfx-v-spacer-large>
		   </cfx-page-section>

		   <cfx-page-section>
				<cfx-paralax-bgnd --image="url('../media/mt-1085-home-bg5.jpg')">
					<cfx-section class="text-center h-center alt-color font-curs">
						<img src="media/title-icon-base.png" alt="">
						<div class="text-800">Hot! Aromatherapy Massage</div>
						<cfx-v-spacer-small></cfx-v-spacer-small>
						<div class="text-topic font-simple">Massage techniques designed to perform in synergy with the therapeutic and reviving properties of pure essential oils, this sensory massage invigorates the body and mind!</div>
						<cfx-v-spacer-large></cfx-v-spacer-large>
						<a class="cfx a-button text-500" type="light" href="" @font-size="24px">VIEW DETAILS</a>
					</cfx-section>
				</cfx-paralax-bgnd>

		   </cfx-page-section>
