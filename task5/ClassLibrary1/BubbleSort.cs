using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Task5
{
    public class BubbleSort
    {
        public ElementSort[] Elements { get; set; }
        private Bitmap bitmap;
        private Graphics gr;
        private Graphics gScreen;
        private Rectangle clientRectangle;

        public BubbleSort(Bitmap map, Graphics gScreen, Graphics gBitmap, Rectangle clientRectangle)
        {
            this.clientRectangle = clientRectangle;
            bitmap = map;
            this.gScreen = gScreen;
            gr = gBitmap;
            Generate(5);
        }

        public Bitmap Sort()
        {
            for (var i = 0; i < Elements.Length / 2; i++)
            {
                bool swapFlag = false;

                for (var j = i; j < Elements.Length - i - 1; j++)
                {
                    if (Elements[j].Inf > Elements[j + 1].Inf)
                    {
                        Change(j, j + 1, i, j);
                        Swap(j, j + 1);
                        swapFlag = true;
                    }
                }

                for (var j = Elements.Length - 2 - i; j > i; j--)
                {
                    if (Elements[j - 1].Inf > Elements[j].Inf)
                    {
                        Change(j, j - 1, i, j);
                        Swap(j - 1, j);
                        swapFlag = true;
                    }
                }

                if (!swapFlag)
                {
                    break;
                }

                
            }
            return bitmap;
        }

        private void Change(int n1, int n2, int n, int m)
        {
            Elements[n1].Color = Color.FromArgb(245, 61, 76);
            Elements[n2].Color = Color.FromArgb(245, 61, 76);
            int x1 = Elements[n1].X;
            int x2 = Elements[n2].X;
            int y1 = Elements[n1].Y;
            double y;
            for (int t = 1; t <= 15; t++)
            {
                y = (x2 - x1) * t / 15;
                Elements[n1].X = x1 + (int)(y);
                switch (t)
                {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        y = 40 * t / 4;
                        Elements[n2].Y = y1 - (int)(y);
                        break;
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        y = (x1 - x2) * (t - 4) / 7;
                        Elements[n2].X = x2 + (int)(y);
                        break;
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        y = 40 * (t - 11) / 4;
                        Elements[n2].Y = (int)(y1 - 40 + y);
                        break;
                }
                Thread.Sleep(10);
                Drawing(n, m);
            }
            Elements[n1].Color = Color.Black;
            Elements[n2].Color = Color.Black;
            Drawing(n, m);
        }


        public void Drawing(int n, int m)
        {
            const int d = 20;

            string s;

            SizeF size;
            Font font = new Font("Nightclub BTN", 16);
            Pen pen = new Pen(Color.Black, 5);

            gr.Clear(Color.FromArgb(21, 40, 64));

            for (int i = 0; i < Elements.Length; i++)

            {
                pen.Color = Elements[i].Color;

                gr.DrawEllipse(pen, Elements[i].X - d,

                Elements[i].Y - d, 2 * d, 2 * d);

                gr.FillEllipse(Brushes.AliceBlue, Elements[i].X - d,

                Elements[i].Y - d, 2 * d, 2 * d);

                s = Convert.ToString(Elements[i].Inf);

                size = gr.MeasureString(s, font);

                gr.DrawString(s, font, Brushes.Black,

                Elements[i].X - size.Width / 2,

                Elements[i].Y - size.Height / 2);

            }
            gScreen.DrawImage(bitmap, clientRectangle);
        }
        public void Generate(int length)
        {
            Elements = new ElementSort[length];
            Random rnd = new Random();
            for (int i = 0; i < Elements.Length; i++)
            {
                Elements[i] = new ElementSort(60 + i * 50, 60, rnd.Next(0, 100), Color.Black);
            }
        }

        private void Swap(int i, int j)
        {
            ElementSort tmp = Elements[i];
            Elements[i] = Elements[j];
            Elements[j] = tmp;
        }
    }
}
