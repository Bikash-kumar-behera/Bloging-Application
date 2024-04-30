import { MantineProvider } from "@mantine/core";

export default function Layout({ children }) {
  return (
    <>
      <MantineProvider>
      {children}
      </MantineProvider>
    </>
  );
}
